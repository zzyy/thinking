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
	private Vo param;
	private int result;
	
	
	@Parameters
	public static List<Object[]> data(){
		return Arrays.asList(new Object[][]{
				{new Vo(1, 2),3},{new Vo(1, 3),-2}
		});
	}
	
	public A2Test(Vo param, int result) {
		this.param = param;
		this.result = result;
	}

	@Test
	public void testAdd() {
		A a = new A();
		assertEquals(result, a.add(param.a, param.b));
		
	}
}

class Vo {
	int a;
	int b;
	public Vo(int a, int b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public String toString() {
		return a +"---" + b;
	}
}