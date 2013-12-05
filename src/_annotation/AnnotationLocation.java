package _annotation;

import _annotation.dev.TestValue;

public class AnnotationLocation {

	@TestValue
	public void sayHi(){
		System.out.println("hi.");
	}
	
	public void sayHi(String name){
		System.out.println(name +"say: hi.");
	}
}
