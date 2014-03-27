package _annotation;

import org.junit.Test;

import _annotation.dev.TestValueProcessor;

public class TestClass {

	public static void main(String[] args) {
		new TestValueProcessor();
		new AnnotationLocation().sayHi();
	}
	
	@Test
	public void test01(){
		
	}
}
