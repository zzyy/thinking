package _IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class CompareFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File orignFile = new File(scanner.nextLine());
		File currFile = new File(scanner.nextLine());
		String[] origin = getFilesName(orignFile);
		String[] curr = getFilesName(currFile);
		scanner.close();
		
		compare(origin, curr);

	}
	
	public static String[] getFilesName(File file){
		String[] list = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir, name).isFile();
			}
		});
		return list;
	}
	
	public static String[] getFileContent(File file){
		List<String> content = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(
					new FileReader(file));
			String tmp = null;
			int i = 0;
			while ((tmp = in.readLine()) != null) {
				content.add(tmp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (String[])content.toArray();
	}
	
	public static void compare(String[] origin, String[] curr){
		Formatter formatter = new Formatter(System.out);
		
		Arrays.sort(origin, String.CASE_INSENSITIVE_ORDER);
		Arrays.sort(curr, String.CASE_INSENSITIVE_ORDER);
		int i=0, j=0;
		while(i!=origin.length && j!=curr.length){
			if(String.CASE_INSENSITIVE_ORDER.compare(origin[i], curr[j]) < 0){
				formatter.format("%-20s\n", origin[i]);
				i++;
			}else if(String.CASE_INSENSITIVE_ORDER.compare(origin[i], curr[j]) == 0){
				i++;
				j++;
			}else{
				formatter.format("%-20s%-20s\n", "", curr[j]);
				j++;
			}
		}
		
		formatter.close();
	}
	
}
