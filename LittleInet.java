import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * 
 * This is to show some net trick
 * 
 * @author PereCastor
 *
 */
public class LittleInet {
	public static void main(String[] args) {
	    
		//Use of INet to show the address name
		try {
	    	
	    	String host = "localhost";
	    	InetAddress address = InetAddress.getByName(host);
	    	
	    	System.out.println("The address IP of " + address.getHostName() + " is " + address.getHostAddress());
	    	
	    } catch (UnknownHostException e){
	    	e.printStackTrace();
	    }
	    
	    //give some things about the url data
		try{
			
			URL url = new URL("http://www.google.com");
			
			System.out.println("Authority : " + url.getAuthority());
	        System.out.println("Default port : " + url.getDefaultPort());
	        System.out.println("Host : " + url.getHost());
	        System.out.println("Port : " + url.getPort());
	        System.out.println("Protocol : " + url.getProtocol());
	        
		} catch (MalformedURLException ex){
			ex.printStackTrace();
		}
	}
}
