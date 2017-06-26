/**
 * 
 * That is a simple classic class that show generic
 * 
 * @author PereCastor
 *
 * @param <T>
 */
class Solo<T>{
	
	private T attribute;
	
	public Solo(){ this.attribute = null;}
	public Solo(T value){
		this.attribute = value;
	}
	
	public void setValue(T val){
		this.attribute = val;
	}
	
	public T getValue(){
		return this.attribute;
	}
	
}

/**
 * 
 * That is a simple classic class that show double generic
 * 
 * @author PereCastor
 *
 * @param <T>
 * @param <S>
 */
class Duo<T, S>{
	
	private T attribute1;
	private S attribute2;
	
	public Duo(){ 
		this.attribute1 = null;
		this.attribute2 = null;
	}
	public Duo(T value1, S value2){
		this.attribute1 = value1;
		this.attribute2 = value2;
	}
	
	public void setValue(T val1, S val2){
		this.attribute1 = val1;
		this.attribute2 = val2;
	}
	
	public T getFirstValue(){
		return this.attribute1;
	}
	
	public S getSecondValue(){
		return this.attribute2;
	}
	
}

public class Generic {
	
	public static void main(String[] args) {
		
		  //Show the Dual Generic
		
		  Duo<String, Boolean> dual = new Duo<String, Boolean>("foo", true);
		  System.out.println("Dual Object : val1 = " + dual.getFirstValue() + ", val2 = " + dual.getSecondValue());
		                
		  Duo<Double, Character> dual2 = new Duo<Double, Character>(12.2585, 'C');
		  System.out.println("Dual Object : val1 = " + dual2.getFirstValue() + ", val2 = " + dual2.getSecondValue()); 
		  
		  
		  System.out.println("*-----------------------------*");
		  
	}

}
