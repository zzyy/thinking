package _RTTI;

class Gum {
	static{
		System.out.println("loading Gum");
	}
}

public class SweetShop {
    public static void main(String[] args) {
		try {
			Class.forName("_RTTI.Gum");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
