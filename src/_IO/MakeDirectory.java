package _IO;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.regex.Pattern;

public class MakeDirectory {
	/**
	 * @param args	file's path
	 */
	public static void main(String[] args) {
		File path = null;
		String[] list;
		if(args.length == 0){
			path = new File(".");
			try {
				new File(".", "test.txt").createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			path = new File(args[0]);
		}
		list = path.list();
		for(String dirItem : list){
			System.out.println(dirItem);
		}
	}
}

