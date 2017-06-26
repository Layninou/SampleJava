/**
 * Create two class to explain  Over Riding.
 * If we ask about Over-loading, it is Polymorphism.
 * @author Layninou
 */

class Animal {
	
   public void move() {
      System.out.println("Animals can move");
   }
   
}

class Cat extends Animal {
	
	/*
	 * Warning: access level cannot be more restrictive than the overridden method's access level.
	 * A method declared final or static cannot be overridden. but static can be rewrite.
	*/
   public void move() {
	  super.move();   // invokes the super/mother class method
      System.out.println("Cats can walk, run and jump");
   }
   
   public void ninja() {
	      System.out.println("Cats can walk like ninjas");
   }
   
}

public class OverRidingExample {
	
	public static void main(String args[]) {
	      Animal a = new Animal();   // Animal reference and object
	      Animal b = new Cat();   // Animal reference but Cat object

	      a.move();   // runs the method in Animal class
	      System.out.println("*-------*");
	      b.move();   // runs the method in Cat class
	      //b.ninja(); // => Error because animal does not have ninja method
	   }

}
