package test;

import java.util.ArrayList;

public class TestArrayList {
	public static void main(String[] args) {
		ArrayList<A> listA = new ArrayList<A>();
		ArrayList<A> listB = new ArrayList<>();
		
		listA.add(new A(0));
		listA.add(new A(1));
		listB.add(new A(2));
		
		listA.addAll(listB);
		
		listB.get(0).m=5;
		System.out.println(listB.get(0).m);
		System.out.println(listA.get(2).m);
	}
}

class A{
	int m;
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public A(){}
	public A(int m) {
		this.m = m;
	}
}
