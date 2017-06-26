import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * From the classic Amazon Interview Question
 * 
 * @author PereCastor
 *
 */
public class FirstNonRepeat {
	
	 public static void main(String[] args)
    {
        System.out.println(" Please enter the input string :" );
        Scanner in = new Scanner (System.in);
        String s=in.nextLine();
        char c=firstNonRepeatedCharacter(s);
        System.out.println("The first non repeated character is :  " + c);
    }
	 
	 public static Character firstNonRepeatedCharacter(String str)
    {
        HashMap<Character,Integer>  characterhashtable= 
                     new HashMap<Character ,Integer>();
        int i,length ;
        Character c ;
        length= str.length();  // for scan the string and build hash table
        for (i=0;i < length;i++)
        {
            c=str.charAt(i);
            if(characterhashtable.containsKey(c))
            {
                // increment count corresponding to c
                characterhashtable.put(  c ,  characterhashtable.get(c) +1 );
                System.out.println(c + " appears " + characterhashtable.get(c));
            }
            else
            {
            	System.out.println(c + " is the first");
                characterhashtable.put( c , 1 ) ;
            }
        }
        
        // Search characterhashtable in in order of string str
        for (i =0 ; i < length ; i++ )
        {
            c= str.charAt(i);
            if( characterhashtable.get(c)  == 1 )
            return c;
        }
        return null ;
    }

}
