class MyHashtagSquare{	
	
	//the hashtag method that will create the tag
	public String makeTheSquare(int input){
		
		String str= "";
		
		for(int it = 0; it < input; it++){
			//There is two case:
			//the case where it is the first or last line
			if( it == 0 || it == input - 1){
				for(int j = 0; j < input; j++){
					str += "#";
				}
				str += "\n"; //next line
			}
			
			//The case where it is an hidden line
			else{
				for(int j = 0; j < input; j++){
					if( j == 0 || j == input -1){
						str += "#";
					}
					else{
						str += " ";
					}
				}
				str +="\n";
			}
		}
		
		return str;
	}
	
	
	//the hashtag method that will create the tag with TWO input
	/**
	 * The general idea is the concatenation.
	 * I already made a function that create a string of #
	 * but now we want to AFFIX a square with another.
	 * 
	 * My first idea was rewrite all the function and think that the square
	 * will be just an unique square. It is not the fastest implementation (and the smartest).
	 * 
	 * The best is to create the two squares and affix them.
	 *  To do it, i decide to make a two dimensional array.
	 *  at each "\n" i will pass the character of the string on the next dimension.
	 *  and after write the string with my array
	 *  
	 *  
	 * I don't think the way i will write this function is the perfect implementation
	 * but it will be a please to speak about it and make it better.
	 * 
	 * This First implementation is what it should done without concatenate string.
	 * 
	 * @param input1
	 * @param input2
	 * @return
	 */
	public String makeTheSquare(int input1, int input2){
		
		//The String that the function will return
		String str= "";
		
		/*
		 * I must found the large number because i choose an array, not a list/collection.
		 *   => do not want to throw an exception: ArrayIndexOfBoundsException
		 * Maybe a Map should be a better idea. But the exercise was in three part so i believe
		 * the next question will ask me to do a Collection
		 */
		int maxInput = input1;
		int minInput = input2;
		if(input1 < input2){
			maxInput = input2;
			minInput = input1;
		}
		// Maybe i should create the case inp1 == inp2 => return makeTheSquare(input1);
		
		// My first idea was this one... with a bi-dimentional array.
		char[][] myArray = new char[maxInput][maxInput + 1];
		for(int i = 0; i < maxInput; i++){
			for(int j = 0; j < maxInput + 1; j++){
				
				myArray[i][j] = ' ';

				if(i == 0 || i == maxInput -1){
					myArray[i][j] = '#';
				}
				if(j == minInput && i <= minInput){
					myArray[i][j] = '#';
				}
				if(i == minInput && j <= minInput){
					myArray[i][j] = '#';
				}
				if(j == maxInput){
					myArray[i][j] = '\n';
				}
				if(j == 0 || j == maxInput -1 ){
					myArray[i][j] = '#';
				}
				
			}
		}
		
		for(int i = 0; i < maxInput; i++){
			for(int j = 0; j < maxInput + 1; j++){
				str += myArray[i][j];
			}
		}
		
		return str;
	}
	
}


public class TestClass {

	public static void main(String[] args){
		
		MyHashtagSquare myHashtagSquare = new MyHashtagSquare();
		
		String mySquare = "####\n#  #\n#  #\n####\n";
		System.out.println(mySquare.equals(myHashtagSquare.makeTheSquare(4)));
		
		System.out.println("\n\n*----------------------------*\n\n");
		
		System.out.println(myHashtagSquare.makeTheSquare(5,2));
		String mySquare2 = "#####\n# # #\n### #\n#   #\n#####\n";
		System.out.println(mySquare2.equals(myHashtagSquare.makeTheSquare(2,5)));
	}
}
