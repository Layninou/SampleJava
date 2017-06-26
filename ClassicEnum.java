enum Langage {
  //Objects that will directly construct
  JAVA("Langage JAVA", "Eclipse"),
  C ("Lanage C", "Code Block"),
  CPlus ("Langage C++", "Visual studio"),
  PHP ("Langage PHP", "PS Pad");

  private String name = "";
  private String editor = "";
   
  //Constructor (Always private)
  Langage(String name, String editor){
    this.name = name;
    this.editor = editor;
  }
   
  //simple method to show
  public void getEditor(){
    System.out.println("Editeur : " + editor);
  }
   
  //we rre construct the toString method
  public String toString(){
    return name;
  }
   
}
public class ClassicEnum {
	public static void main(String args[]){
	    Langage l1 = Langage.JAVA;
	    Langage l2 = Langage.PHP;
	      
	    l1.getEditor();
	    l2.getEditor();
	}
	
}
