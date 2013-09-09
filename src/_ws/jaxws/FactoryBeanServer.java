package _ws.jaxws;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class FactoryBeanServer {
	static void start(){
		System.out.println("start.");
		HelloWorldImp implementor = new HelloWorldImp();
		JaxWsServerFactoryBean serverFatory = new JaxWsServerFactoryBean();
		
		serverFatory.setAddress("http://localhost:8888/helloWorld");
		serverFatory.setServiceClass(HelloWorld.class);
		serverFatory.setServiceBean(implementor);
		
		serverFatory.create();
	}
	
	public static void main(String[] args) throws InterruptedException {
		start();
		System.out.println("ready...");
		
		Thread.sleep(5*60*1000);
		System.out.println("exit");
		System.exit(0);
	}
}
