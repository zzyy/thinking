package _String;

import java.util.Arrays;
import java.util.regex.Pattern;

public class RegExpTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "this is a test string";
		System.out.println( Arrays.toString( str.split(" ") ));
		System.out.println( Arrays.toString( Pattern.compile(" ").split(str) ));
	}

}
