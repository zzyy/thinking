package _ws.jaxws;

import javax.xml.ws.Endpoint;

public class Server {

	/**
	 * @param args
	 */
	private static void  start() {
		System.out.println("Starting...");
		HelloWorldImp implementor = new HelloWorldImp();
		String address = "http://localhost:8888/helloWorld";
		Endpoint.publish(address, implementor);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		start();
		System.out.println("ready...");
		
		/*Thread.sleep(5*60*1000);
		System.out.println("exit");
		System.exit(0)*/;
	}
}
