package _junitTest.yun;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class A2Test {
	private Object[] param;
	private Object result;
	
	
	@Parameters
	public static List<Object[][]> data(){
		return Arrays.asList(new Object[][][]{
				{{0,1,3}},{{-1,-2,3}}
		});
	}
	
	public A2Test(Object[] param, Object result) {
		this.param = param;
		this.result = result;
	}

	@Test
	public void testAdd() {
		System.out.println(param +"-"+ result );
		
	}


}
