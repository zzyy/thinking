package _String;

import java.io.PrintStream;
import java.util.Formatter;

public class FormatterTest {
	public static void main(String[] args) {
		PrintStream out = System.out;
		Formatter f = new Formatter(out);
		f.format("X: %x\n", 13);
		System.out.println(f.out());
		System.out.println(out);
	}

}
