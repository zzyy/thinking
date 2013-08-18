package _IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

public class ZipTest {

	public static void main(String[] args) {
		File outZip = new File(".//test.zip");
		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outZip));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
