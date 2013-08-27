package _Spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//annocation aop ²ÉÓÃaspectÉùÃ÷aop
@Component
@Aspect
public class AspectTest {

	@Before("execution(* display*(..))")
	public void beforeMethod(){
		System.out.println(">>>before(aspect)");
	}

}
