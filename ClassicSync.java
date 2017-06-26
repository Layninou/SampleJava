import java.io.IOException;
import java.sql.Connection;

/**
 * Should we double check?
 * Avoid synchronization because it's "slow" is old story.
 * 
 * @author Layninou
 */
public class ClassicSync {
	
	private static ClassicSync instance;

  public static synchronized ClassicSync getInstance() {
    if (instance == null) {instance = new ClassicSync();}
    return instance;
  }

  private ClassicSync() {}

}

/**
 * Should we double check?
 * We could create a class that check if it is load or not.
 * If not, it init the class and load it. So it must be static
 * 
 * It is a Singleton ^^
 * 
 * @author Layninou
 */
class Loader {
	
	private static final Loader instance = new Loader();

    public static Loader getInstance() {
	  return instance;
	}
	
	private Loader() {}

}

/**
 * Or in more Beautiful:
 * 
 * @author Layninou
 */
class Loader2 {
	
	private static final Loader2 instance;

	static {
	    try {
	      instance = new Loader2();
	    } catch (IOException e) {
	      throw new RuntimeException("An error's occurred: ", e);
	    }
	  }

	  public static Loader2 getInstance() {
	    return instance;
	  }

	  private Loader2() throws IOException {
	    // read configuration files...
	  }

}


/**
 * Or an other solution: volatile
 * we make the instance reference volatile
 * 
 * @author Layninou
 */
class ClassicVolatile {

	private static volatile ClassicVolatile instance;

    public static ClassicVolatile getInstance(Connection conn)
         throws IOException {
      if (instance == null) {
        synchronized (ClassicVolatile.class) {
          if (instance == null)
            instance = new ClassicVolatile(conn);
        }
      }
      return instance;  
    }

    private ClassicVolatile(Connection conn) throws IOException {
      // init factory using the database connection passed in
    }
}