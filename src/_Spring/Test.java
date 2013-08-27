package _Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@org.junit.Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("./_Spring/beans.xml");
		
		System.out.println(context);
		Target target = (Target) context.getBean("target");
		
		target.display();
		
	}
	
	@org.junit.Test
	public void test2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("./_Spring/beans2.xml");
		
		System.out.println(context);
		Target target = (Target) context.getBean("target");
		PointcutMethod point = (PointcutMethod) context.getBean("pointcutMethod");
		System.out.println(point);
		target.display();
		
	}
}
