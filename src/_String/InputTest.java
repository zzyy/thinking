package _String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static String bufferedReaderTest() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		return bufferedReader.readLine();
	}
	
	public static Scanner scanner(){
		return new Scanner(System.in);
	}
	
	public static void main(String[] args) throws IOException {
		String str;
		str = bufferedReaderTest();
		System.out.println(str);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println(scanner.nextLine());
	}

}
