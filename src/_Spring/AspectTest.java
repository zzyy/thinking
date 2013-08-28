package _Spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//annocation aop ²ÉÓÃaspectÉùÃ÷aop
@Component
@Aspect
@Order(50)
public class AspectTest {

	@Before("execution(* display*(..))")
	public void beforeMethod(){
		System.out.println(">>>before(aspect)");
	}

	@After("execution(* display*(..))")
	public void afterMethod(){
		System.out.println(">>>after(aspects)");
	}
}
