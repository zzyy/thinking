package _Date;

import java.util.Calendar;
import java.util.TimeZone;

public class CurrentTime {
	public static void main(String[] args) {
		Calendar time = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		System.out.println(time);
		
		
	}
}
