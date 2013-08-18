package _IO;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileRenameTest {
	public static void main(String[] args) throws IOException {
		File origin = new File(".\\test2.txt");
		fileContent(origin);
		File dest = new File(".\\test.txt");
		System.out.println(origin.setWritable(true));
		System.out.println(origin.canWrite());
		System.out.println(origin.renameTo(dest));
	}
	
	public static void fileContent(File f){
		DataInputStream in = null;
		String tmp = null;
		try {
			in = new DataInputStream( new FileInputStream(f) );
			tmp = in.readLine();
			while(tmp != null){
				System.out.println(tmp);
				tmp = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
