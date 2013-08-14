package _String;

public class Concatenation {

	/**
	 * @param args
	 */
	@Override
	public String toString(){
		return super.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mango="mango";
		String s=mango+ "abc";
		Concatenation c= new Concatenation();
		System.out.println(c);
		System.out.println(c.getClass().getName() +"@"+ Integer.toHexString(c.hashCode()) );
	}

}
