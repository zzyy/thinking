package _Spring;

public class Target {
	Bean bean=null;

	public void setBean(Bean bean) {
		this.bean = bean;
	}
	
	public void getId(){
		System.out.println(">>>fn1--" + bean.getId());
	}
	
	public void getName(){
		
		System.out.println(">>>getName--"+bean.getName());
	}
}
