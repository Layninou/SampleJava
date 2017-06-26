import java.io.*;

/**
 * Show how Read and Write File
 * 
 * @author Layninou
 */
class CopyFile {

   public void Copy() throws IOException {  
      FileInputStream in = null;
      FileOutputStream out = null;

      try {
    	  //We instantiate the 2 object, in and out/ read and write
         in = new FileInputStream(new File("res/input.txt"));
         out = new FileOutputStream(new File("res/output.txt"));
         
         //We declare a byte array to indicate the number of byte read but round
         byte[] buf = new byte[8];
         
         //We create a read result in. -1 mean finish
         int n = 0;
         while ((n = in.read(buf)) >= 0) {
        	 // we write on the output
            out.write(buf);
            
            //we show what we read
            for (byte bit : buf){
            	System.out.print(bit + "(" + (char) bit + ") ");
            }
            System.out.println("");
            
            //Re-init the buffer
            buf = new byte[8];
         }
         
      }finally {
    	  //Always CLOSE the file we interact with
    	 System.out.println("");
         if (in != null) {
            in.close();
            System.out.println("We close the reading");
         }
         if (out != null) {
            out.close();
            System.out.println("We close the writing");
         }
      }
   }
}

/**
 * Same but use to be write/read in a txt file
 * the file reader read char but the FileInput read byte.
 * 
 * @author Layninou
 */
class CopyFileReader {

   public void Copy() throws IOException {  
	   FileReader  in = null;
       FileWriter out = null;

      try {
         in = new FileReader(new File("res/inputReader.txt"));
         out = new FileWriter(new File("res/outputReader.txt"));
         
         int c;
         while ((c = in.read()) != -1) {
            out.write(c);
         }
      }finally {
    	 System.out.println("");
         if (in != null) {
            in.close();
            System.out.println("We close the reading");
         }
         if (out != null) {
            out.close();
            System.out.println("We close the writing");
         }
      }
   }
}

class ClassicFile{
	
	//Create a new File Object
    public static File f = new File("res/ResTest.txt");
    
    public void showFile(){
    	System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
        System.out.println("Nom du fichier : " + f.getName());
        System.out.println("Est-ce qu'il existe ? " + f.exists());
        System.out.println("Est-ce un répertoire ? " + f.isDirectory());
        System.out.println("Est-ce un fichier ? " + f.isFile());
    }
    
}

public class Flux {	
	public static void main(String[] args){
		
		System.out.println("*----------------------*");
		System.out.println("Start of the Stream Copy");
		System.out.println("*----------------------*");
		
		CopyFile cp = new CopyFile();
		try{
			cp.Copy();
		} catch (IOException ex){
			System.out.println("An exception happens: " + ex);
		}
		
		System.out.println("*----------------------*");
		System.out.println("Start of the Reader Copy");
		System.out.println("*----------------------*");
		
		CopyFileReader cpr = new CopyFileReader();
		try{
			cpr.Copy();
		} catch (IOException ex){
			System.out.println("An exception happens: " + ex);
		}
		
		System.out.println("*----------------------*");
		System.out.println("Begin Classic File Reading");
		System.out.println("*----------------------*");
		
		ClassicFile File = new ClassicFile();
		File.showFile();
		
	}
	
	
	/**
	 * Warning: When you read a large file you need to put a buffer like:
	 * BufferInputStream( new FileInputStream("my file"))
	 * 
	 * And when you want to create a data file that will be re-read use:
	 * Data(Input / Output)Stream
	 * 
	 * With Object : Object(I/O)Stream with the interface Serializable.
	 * When you serialize an Object, declare the no serialized attribute with a "transient"
	 * but that will make the object "ignored"
	 */
}
