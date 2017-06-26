/**
 * 
 * We will implement a simple singleton
 * and show some easy form
 * 
 * @author Layninou
 *
 */
public class Singleton {

	//The constructor must be private
	private Singleton(){}
	
	//The instance must be unique
	private static Singleton instance = new Singleton();
	
	//And an access method
	public static Singleton getInstance(){
		return instance;
	}
	
}

/**
 * 
 * Now a lazy Loading Singleton
 * It is when you not create an automatic instance at the begging of the application.
 * But when you want to create one.
 * 
 * @author Layninou
 *
 */
class LazySingleton {

	//The constructor must be private
	private LazySingleton(){}
	
	//The instance must be unique
	private static LazySingleton instance = null;
	
	//And an access method
	public static LazySingleton getInstance(){
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
}

/**
 * 
 * The LazySingleton cannot survive in multithread so:
 * 
 * @author Layninou
 *
 */
class SyncSingleton {

	//The constructor must be private
	private SyncSingleton(){}
	
	//The instance must be unique
	private static SyncSingleton instance = null;
	
	//And an access method
	public static synchronized SyncSingleton getInstance(){
		if (instance == null) {
			instance = new SyncSingleton();
		}
		return instance;
	}
	
}

/**
 * Still not perfect so we will to double check lock
 * 
 * @author Layninou
 *
 */
class LocalSyncSingleton {

	//The constructor must be private
	private LocalSyncSingleton(){}
	
	//The instance must be unique
	private static LocalSyncSingleton instance = null;
	
	//And an access method
	public static LocalSyncSingleton getInstance(){
		if (instance == null) {
			synchronized (Singleton.class){
				instance = new LocalSyncSingleton();
			}
		}
		return instance;
	}
	
}

/**
 * 
 * The bes Singleton... The Singleton Holder
 * Complex to understand but perfect (work in multi thread)
 * 
 * When the intern class will be initiate, it will initiate its static final attribute
 *    => Create an unique instance.
 * 
 * @author PereCastor
 *
 */
class HSingleton {

	//The constructor must be private
	private HSingleton(){}
	
	//Holder
	private static class SingletonHolder{
		//The instance will be unique => final and static
		private final static HSingleton instance = new HSingleton();	
	}
	
	
	
	//And an access method
	public static HSingleton getInstance(){
		return SingletonHolder.instance;
	}
	
}