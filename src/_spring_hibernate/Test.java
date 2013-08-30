package _spring_hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	@org.junit.Test
	public void query(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("./_spring_hibernate/transcationBeans.xml");
		DaoSupport hibernateDaoSupport = (DaoSupport) applicationContext.getBean("hibernateDaoSupport");
		hibernateDaoSupport.loadAll();
	}
	
	@org.junit.Test
	public void daoSupportAdd(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("./_spring_hibernate/transcationBeans.xml");
		DaoSupport hibernateDaoSupport = (DaoSupport) applicationContext.getBean("hibernateDaoSupport");
		hibernateDaoSupport.add();
	}
	
	@org.junit.Test
	public void add() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("./_spring_hibernate/transcationBeans.xml");
		TranscationTest transcationTest = applicationContext.getBean("transcationTest", TranscationTest.class);
		transcationTest.add();
	}
}
