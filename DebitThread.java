import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This is an example to show Lock and Condition
 * 
 * @author PereCastor
 *
 */
class ThreadPull extends Thread{
	
	private DebitThread dbT;
	private Random rand = new Random();
	private static int nbThread = 1;
	
	public ThreadPull(DebitThread db){
		this.dbT = db;
		this.setName("Output " + nbThread++);
	}
	
	
	public void run() {
        while(true){
           int nb = rand.nextInt(300);
           long amount = Integer.valueOf(nb).longValue();   
           dbT.withDrawal(amount);
       
           try {
              Thread.sleep(1000);
           } catch (InterruptedException e) {}          
       }
   }
}


class ThreadPush extends Thread{
	
	private DebitThread dbT;
	private Random rand = new Random();
	
	public ThreadPush(DebitThread db){
		this.dbT = db;
		this.setName("Input");
	}
	
	
	public void run() {
        while(true){
           int nb = rand.nextInt(300);
           long amount = Integer.valueOf(nb).longValue();   
           dbT.deposit(amount);
       
           try {
              Thread.sleep(1000);
           } catch (InterruptedException e) {}          
       }
   }
}

public class DebitThread {
	
	private AtomicLong balance = new AtomicLong(1_000L);
	private final long overdraft = -130L;
	private AtomicLong nbDebitTry = new AtomicLong(0);
	
	//THE lock and it condition
	private Lock myLock = new ReentrantLock();
	private Condition condition = myLock.newCondition();
	
	/**
	 * 
	 * This method will pull money if we can during the thread
	 * 
	 * @param amount
	 * @author PereCastor
	 */
	public void withDrawal(long amount){
		myLock.lock(); //we lock the thread !
		String threadName = Thread.currentThread().getName();
		try{
			
			//We will make the thread wait if we do not have enough money
			while((balance.get() - amount) < overdraft){
				System.err.println(threadName + " try to pull " + amount);
				nbDebitTry.addAndGet(amount); //=> we keep the money we must give
				condition.await(); // => we make wait the Thread before continue withdrawal
			}
			
			//here we can pull some money
			balance.set(balance.get() - amount);
			showBalance();
			
		} catch (Exception unimportant){
			
		} finally{
			myLock.unlock(); //Always a final to unlock the thread
		}
	}
	
	/**
	 * 
	 * This method push money in the account
	 * 
	 * @author PereCastor
	 * @param amount
	 */
	public void deposit(long amount){
		//this is the same lock
		myLock.lock();
		
		try {
			
			long result = balance.addAndGet(amount);
			showBalance();
			
			
			// can we pull money?
			long balanceAfterPull = getBalance() - nbDebitTry.get();
			if(balanceAfterPull > overdraft){
				nbDebitTry.set(0); //no debt
				condition.signalAll(); //Wake up the condition
				System.out.println("\n Balance after withdrawal : " + balanceAfterPull + " < Overdraft");
			}
			
		} finally {
			myLock.unlock(); //Never ever forget to unlock
		}
	}
	
	/**
	 * Show the balance in the account
	 */
	public void showBalance(){
		System.out.println("Actual balance, in " + Thread.currentThread().getName()
                           + " : " +  balance.longValue());
	}
	
	//Getter and Setter
	public long getBalance(){
		return balance.longValue(); //it is an atomic long
	}
	public long getOverdraft(){
		return overdraft;
	}
	
	
	/**
	 * Do the Thing
	 * @param args
	 */
	public static void main(String[] args){
		
		DebitThread myAccount = new DebitThread();
		
		//The two thread that will pull money
		Thread t1 = new ThreadPull(myAccount);
		Thread t2 = new ThreadPull(myAccount);
		
		t1.start();
		t2.start();
		
		//the thread that will push money
		Thread t3 = new ThreadPush(myAccount);
		t3.start();
	}

}
