package _String;

import java.util.Scanner;

public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String tmp = scanner.nextLine();
		
		int num = Integer.valueOf(tmp);
		tmp = String.valueOf(num);
		
		int num1 = Integer.valueOf(String.valueOf(tmp.charAt(0))) + Integer.parseInt(tmp.substring(1,2));
		
		System.out.println(num1);
	}

}
