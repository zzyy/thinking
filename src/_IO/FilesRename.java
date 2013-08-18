package _IO;

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FilesRename {

	public static void main(String[] args) {
//		final Pattern regex = Pattern.compile("\\\\[电影天堂-www\\\\.dy2018\\\\.net\\\\]");
		final Pattern regex = Pattern.compile(".*电影天堂.*");
		
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		String originContent = null;
		originContent = scanner.nextLine();
		scanner.close();
		File origin = new File(originContent);
		
		File[] origins = origin.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				String curr = pathname.getName();
				System.out.println(curr);
				System.out.println(regex.matcher(curr).matches());
				System.out.println(Pattern.compile("电影天堂").matcher(curr).matches());
				
				if(regex.matcher(curr).matches())
					return true;
				return false;
			}
		});
		
		int i = 0;
		for(File f : origins){
			System.out.println(f.setWritable(true));
			String dest = Pattern.compile("电影天堂").matcher(f.getPath()).replaceAll("");
			System.out.println(dest);
			if(f.renameTo(new File(dest))){
				i++;
			}
		}
		
		System.out.println("totle: " + origins.length +" files, renamed: "+i +" files");
	}

}
