package test;

public class ClassA {

	public static void main(String[] args) {
		B b = new B();
		modifyB(b);
	}
	
	static void modifyB(final B b){
		System.out.println(b.m);
		b.setM(3);
		System.out.println(b.m);
//		b = new B(); ´íÎó
	}
}

class B{
	int m=0;
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
}
