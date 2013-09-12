package _junitTest.yun;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class A3Test {
	private Object[] param;
	private int result;
	
	
	@Parameters
	public static List<Object[]> data(){
		return Arrays.asList(new Object[][]{
				{new Object[]{1,2},3},{new Object[]{-3,1},-2}
		});
	}
	
	public A3Test(Object[] param, int result) {
		this.param = param;
		this.result = result;
	}

	@Test
	public void testAdd() {
		A a = new A();
		System.out.println(Arrays.toString(param) +" >>>"+ result);
		assertEquals(result, a.add((Integer)param[0], (Integer)param[1]));
	}
}

