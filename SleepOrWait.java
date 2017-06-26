import java.util.Vector;
/**
 * 
 * A wait must be notified to execute after be waited
 * 
 * @author PereCastor
 *
 */
class myThread extends Thread{
	
	static final int MAX_QUEUE = 5;
	private Vector msg = new Vector();
	
	@Override
	public void run(){
		try{
			while(true){
				putMessage();
				//sleep(500); //It will be different... the thread will wait 500ms before acting again
			}
		} catch( InterruptedException unimportant){
			
		}
	}
	
	
	private synchronized void putMessage() throws InterruptedException {
		while(msg.size() == MAX_QUEUE){
			wait();
		}
		msg.addElement(new java.util.Date().toString());
		System.out.println("A message was put in the thread");
		notify(); //We notify to let the thread reworking
		
	}
	
	public synchronized String getMessage() throws InterruptedException {
		notify();
		while( msg.size() == 0){
			wait(); //The Thread go sleep till it is notify to restart working. 
		}
		String message = (String) msg.firstElement();
		msg.removeElement(message);
		return message;
	}
}


public class SleepOrWait extends Thread {
	
	myThread t;
	SleepOrWait(myThread t) {this.t= t;}
	
	@Override
	public void run() {
		try{
			while(true){
				String message = this.t.getMessage();
				System.out.println("Got the message: " + message);
				
			}
		} catch( InterruptedException ex){
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		
		myThread theWait = new myThread();
		theWait.start();
		new SleepOrWait (theWait).start();
		
	}
	
}
