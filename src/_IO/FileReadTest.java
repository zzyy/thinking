package _IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.print.attribute.standard.Chromaticity;

public class FileReadTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File testFile = null;
		if(args.length ==0){
			testFile = new File("./test.txt");
		}else{
			testFile = new File(args[0]);
		}
		
		BufferedReader in = null;
		String bufferedStr = null;
		try {
			in = new BufferedReader(
					new FileReader(testFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while((bufferedStr = in.readLine()) != null){
			System.out.println(bufferedStr);
		}
		in.close();
		
		
		//nIO
		FileChannel fc = new FileInputStream(testFile).getChannel();
		ByteBuffer buff = ByteBuffer.allocate((int) fc.size());
		System.out.println("position:--------" + fc.position());
		fc.read(buff);
		byte[] byteArr = buff.array();
		/*for(byte b: byteArr){
			System.out.println(b + "--" + (char)b);
		}*/
		System.out.println(new String(byteArr));
		
		System.out.println("position:--------" +fc.position());
		fc.close();
	}
	
	
}
