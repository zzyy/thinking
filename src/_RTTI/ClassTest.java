package _RTTI;

interface One{}
interface Two{}

class Toy{
//	public Toy() {}
	
	public Toy(int i){}
}

class FancyToy extends Toy implements One, Two{
	public FancyToy(){super(1);}
}

public class ClassTest {

	static void pritfInfo(Class c){
		System.out.println(c.getName()+"-"+c.isInterface()+"-"+c.getSimpleName()+"-"+c.getCanonicalName());
	}
	
	public static void main(String[] args) {
		Class c=null;
//		c = new FancyToy().getClass();
		c = FancyToy.class;
		try {
			c = Class.forName("_RTTI.FancyToy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		pritfInfo(c);
		
		for(Class imp: c.getInterfaces()){
			pritfInfo(imp);
		}
		
		Class supClass = c.getSuperclass();
		pritfInfo(supClass);
	}

}
