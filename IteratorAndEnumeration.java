import java.util.Collections;
import java.util.Iterator;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 * To explain Iterator vs Enumeration
 * 
 * Iterators allow the caller to remove elements from the underlying collection
 *  during the iteration with well-defined semantics.
 * Iterator actually adds one method that Enumeration doesn’t have: remove ().
 * 
 * @author Layninou
 */
public class IteratorAndEnumeration {	
	public static void main(String[] args) {
		
		List<String> linkList = new LinkedList<String>();
		
		linkList.add("key1");
		linkList.add("key2");
		linkList.add("key3");
		linkList.add("key4");
		linkList.add("key5");
		
		//Iterator Directly remove an element in the list
		Iterator<String> iterList = linkList.iterator();
		while(iterList.hasNext()){
			if( ( (String) iterList.next() ).equals("key4")){
				iterList.remove();
			}
		}
		
		
		/*
		 * Enumeration: dynamic removal of element from the list
		 * Enumeration with non-synchronized list
		 */
		Enumeration<String> enumList = Collections.enumeration(linkList);
		while(enumList.hasMoreElements()){
			System.out.println( (String) enumList.nextElement());
		}
		
	}
}
