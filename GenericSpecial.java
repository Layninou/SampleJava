import java.util.ArrayList;
import java.util.List;

/**
 * 
 * In the first part, we have two class with one who extends from another
 * 
 * @author PereCastor
 *
 */
class Dog{
	
	private String dog;
	
	public Dog(){
		this.dog = "a dog";
	}
	
}
class KingCharles extends Dog{
	
	private String kDog;
	
	public KingCharles(){
		this.kDog = "a kingcharles";
	}
}

/**
 * Here we will create a class with a wildcard <?>
 * 
 * @author PereCastor
 *
 */
class PetShop{
	
	List<Dog> list = new ArrayList<Dog>();
	
	//Wildcard must be always use in a reading process
	public void addDog(List <? extends Dog> listDog){
		for(Dog d: listDog)
			list.add(d);
		
		for(Dog d: list)
			System.out.println(d.toString());
	}
}

public class GenericSpecial {
	
	public static void main(String[] arg){
		
		List<Dog> listDog = new ArrayList<Dog>();
		listDog.add( new Dog() );
		listDog.add( new Dog() );
		
		List<KingCharles> listKC = new ArrayList<KingCharles>();
		listKC.add( new KingCharles() );
		
		PetShop pt = new PetShop();
		
		pt.addDog(listDog);
		System.out.println("*------------------*");
		pt.addDog(listKC);
	}

}
