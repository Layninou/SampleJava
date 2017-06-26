import java.lang.reflect.Method;

/**
 * Reflection allows programmatic access to information about a Java program’s types
 *  => So it is like using method in a class without knowing the class
 *  
 * @author PereCastor
 *
 */
public class ReflectClass {
	
	public static void main(String[] args){
		
		Method[] methods = Object.class.getMethods();
		System.out.println("Objects has " + methods.length + " methods");

		for(Method method : methods){
		    System.out.println("method: " + method.getName());
		}
		
	}

	
	
}
