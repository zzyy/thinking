package _ws.jaxws;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class FaxtoryBeanClient {
	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress("http://localhost:8888/helloWorld");
		
		HelloWorld client = factory.create(HelloWorld.class);
		System.out.println(client.sayHi("zy"));
	}
}
