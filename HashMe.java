import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * Practice of the HashMap Questions
 * 
 * Three import thing:
 * 1/ Hash Function: it is the HashCode() that return an integer
 *      => public native int HashCode();
 * 2/ Hash Value: It is the Integer return by the Hash Function
 * 3/ Bucket: It is the Store of the Key/Value. A LinkedList
 * 
 * Key and Value are stored in a nested class name Entry(Map.Entry)
 *     => all is stored in the bucket as a form of an entry object
 * 
 * Whenever we call get(Key k) => first check if the key is not null.
 * There can be only one null key. if null key => index 0 => hash 0
 * If not null: integer hash = hash(hashValue).
 *  => why calculate hash again. Defends against poor quality hash function.
 *  Now the hash value is used to find the entry in the bucket.
 *   => Entry are like (hash, key, value, bucketIndex) 
 *   
 *   
 * WARNING: when two different key have the same hashCode?
 *  => use equals() method. the bucket is a LinkedList (simpler).
 *  So we traverse the list comparing key with each entry until it is true.
 *  
 * W2: when two same key and value?
 *  => Overriding
 *  
 * W3: Constant time performance for basic operations.
 *  
 * Question: how mesure performance? => Capacity & Load Factor
 *  => Capacity = the number of buckets in the hash table
 *  => Load Factor = how full is the hash table
 *  
 * Question 2: difference between HashMap and ConcurrentHashMap
 *  => ConcurrentHashMap is threadSafe (a single thread at a time)
 *  =>  ,, has not null key.
 *  => HashMap can be synchronizedMap and is faster than CHM
 * 
 * @author PereCastor
 *
 */
public class HashMe {
	
	
	public static void printMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	public static void equalMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    Iterator it2 = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println("it1");
	        while (it2.hasNext()){
	        	Map.Entry pair2 = (Map.Entry)it2.next();
	        	System.out.println("it2");
	        	if( pair.getValue() == pair2.getValue()){
	        		System.out.println("Value of " + pair.getKey() + " = " + pair2.getKey());
	        	}
	        	it2.remove();
	        }
	        it.remove();
	    }
	}
	
	
	public static void main(String[] args){
		
		HashMap<String, Integer> myHM = new HashMap<String,Integer>(); 
		myHM.put("Key1", 25);
		myHM.put("Key2", 28);
		myHM.put("Key3", 12);
		myHM.put("Key2", 28); //Overriding
		myHM.put("Key4", 12);
		
		printMap(myHM);
		//equalMap(myHM);  //Warning ConcurrentModificationException => maybe use concurrent hashmap but i believe my method is not right writing
		
	}
}
