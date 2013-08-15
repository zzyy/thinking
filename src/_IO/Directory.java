package _IO;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class Directory {
	/**
	 * @param args	file's path
	 */
	public static void walk(File file){
		File[] files = file.listFiles();
/*		File[] files = file.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return false;
			}
		});*/
		for(File fileItem: files){
			if(fileItem.isFile()){
				System.out.println(fileItem +"- file");
			}else{
				System.out.println(fileItem +"- directory");
				walk(fileItem);
			}
		}
	}
	
	public static void main(String[] args) {
		File path = null;
		if(args.length == 0){
			path = new File(".");
		}else {
			path = new File(args[0]);
		}

		walk(path);
	}
}


