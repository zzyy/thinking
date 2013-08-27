package _Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	@org.junit.Test
	public void DITest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Target target = (Target) context.getBean("target");
	}
}
