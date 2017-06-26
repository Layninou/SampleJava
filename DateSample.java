import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Create a simple date format
 * @author Layninou
 */
public class DateSample {
	
	public static void main(String[] args) {
     
		SimpleDateFormat sysForm = new SimpleDateFormat("yyyy/MM/DD HH:mm:ss");
        Date curdate= new Date();
        System.out.println(sysForm.format(curdate));
        
	}

}
