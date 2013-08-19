package _Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String formatStr="yyyy-MM-dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
		Date date = dateFormat.parse("2013-7-1");
		System.out.println(dateFormat.format(date));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm a");
		SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
//		Date date2 = sdf2.parse("01:00 ÏÂÎç");
//		Date date2 = sdf2.parse("12:08 PM");
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
		Date date3 = sdf4.parse("2013-01-29");
		
		System.out.println(sdf4.format(date3));
		
	}

}
