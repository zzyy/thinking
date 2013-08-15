package _IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList {
	/**
	 * @param args	file's path
	 */
	public static void main(String[] args) {
		File path = null;
		String[] list;
		if(args.length == 0){
			path = new File("C:\\");
		}else {
			path = new File(args[0]);
		}
//		list = path.list();
		list = path.list(new DirFilter("W\\w*"));
		for(String dirItem : list){
			System.out.println(dirItem);
		}
	}
}

class DirFilter implements FilenameFilter{
	private Pattern pattern;
	public DirFilter(String regex) {
		this.pattern = Pattern.compile(regex);
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
}
