/**
 * To explain Throw vs Throws
 * 
 * Throws => for catching the exceptions a method can make.
 * Throw => You want to catch this exception and do something with it.
 * 
 * @author Layninou
 */
class FooException extends Exception {
	
  public FooException() { super(); }
  public FooException(String message) { super(message); }
  public FooException(String message, Throwable cause) { super(message, cause); }
  public FooException(Throwable cause) { super(cause); }
  
}

public class ThrowOrThrows {
	
	// THROWS
	
	public void myMethod() throws Exception{ 
		//Do the thing 
	}

	//This means the super function calling the function should be equipped to handle this exception.
	
	public void Callee(){
		try{
			myMethod();
		}catch(Exception ex){
			//handle The Exception....
		}
	}
	
	//THROW
	
	int exception;
	
	public void myException(){
		try{
			if(exception>10){
				throw new FooException(); //Customized Exception
			}
			else{
				//Do a thing
			}
		}catch(FooException ex){
			//handle My Exception.....
		}
	}

}
