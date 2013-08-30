package _Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;

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
	
	@org.junit.Test
	public void resourceTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("./_Spring/beans2.xml");
		JdbcTemplate sdf=null;
	}
}
