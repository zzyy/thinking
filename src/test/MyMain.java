package test;

class Singleton {
	private static Singleton obj = new Singleton();
	public static int counter1;
	public static int counter2 = 0;

	private Singleton() {
		counter1++;
		counter2++;
	}

	public static Singleton getInstance() {
		return obj;
	}
}

// ³ÌÐò2
public class MyMain {
	public static void main(String[] args) {
		Singleton obj = Singleton.getInstance();
		System.out.println("obj.counter1==" + obj.counter1);
		System.out.println("obj.counter2==" + obj.counter2);
	}
	
}
