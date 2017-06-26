/**
 * 
 * ThreadLocal can store value for each thread.
 * In this example we store a integer for each thread
 * If we do not use ThreatLocal in the run method, the second thread
 *  should erase the first thread value. Not with a sotre like ThreadLocal
 * 
 * 
 * ThreadLocal is a subclass of Thread
 * 
 * @author PereCastor
 *
 */
public class ThreadLocalExample {
	
	public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal =
               new ThreadLocal<Integer>();

        @Override
        public void run() {
            threadLocal.set( (int) (Math.random() * 100D) );
    
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
    
            System.out.println(threadLocal.get());
        }
    }


    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        try{
        	thread1.join(); //wait for thread 1 to terminate
            thread2.join(); //wait for thread 2 to terminate
        } catch (InterruptedException unimportant){
        	
        }
        
    }

}
