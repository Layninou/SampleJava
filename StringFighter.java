
/**
 * Create to explain String and answer simple string question.
 * @author Layninou
 */
public class StringFighter {
	
	public static void main(String args[]) {
		
		//String object is immutable => never change the initial String.
		String myString = "Hello";
		myString += " World";
		
		//That explain "pool security" problem. Use a char array instead.
		
		// When new is use, it create a new instance of String. So new immutable String
		String mySecondString = new String("Hello New World");
		
		//But StringBuffer is mutable and synchronized
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(myString); // => append() more efficient
		System.out.println(strBuffer);
		
		//StringBuilder as well but not synchronized
		StringBuilder strBuilder = new StringBuilder(15);
		strBuilder.append(mySecondString);
		System.out.println(strBuilder);
		
		//And that will let less garbage allocation :)
	}
	
}
