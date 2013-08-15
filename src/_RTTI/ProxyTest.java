package _RTTI;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Interface{
	void doSomething();
	void doElse(String str);
}

class RealObj implements Interface{
	@Override
	public void doSomething() {}
	@Override
	public void doElse(String str) {
		System.out.println(str);
	}
}

//代理模式
class SimpleProxy implements Interface {
	private Interface proxied;
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}
	@Override
	public void doSomething() {
		proxied.doSomething();
	}
	@Override
	public void doElse(String str) {
		proxied.doElse(str);
	}
}

//DynamicProxy
class SimpleDynamicProxy implements InvocationHandler{
	private Object proxied;
	public SimpleDynamicProxy(Object proxied) {
		this.proxied = proxied;
	}
	
	public Object newProxyInstance(){
		return Proxy.newProxyInstance(
					proxied.getClass().getClassLoader(), 
					proxied.getClass().getInterfaces(),
					this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("---DynamicPfoxy---");
		System.out.println("proxy:"+proxy.getClass());
		System.out.println("method:"+method);
		System.out.println("args:" + args);
		System.out.println("**************");
		return method.invoke(proxied, args);
	}
	
	
}

public class ProxyTest {
	
	public static void main(String[] args) {
		RealObj realObj = new RealObj();
		Interface proxy = null;
		proxy = new SimpleProxy(realObj);
		proxy.doElse("--doing--");
		
		proxy = (Interface) new SimpleDynamicProxy(realObj).newProxyInstance();
		proxy.doElse("--doing--");
	}

}
