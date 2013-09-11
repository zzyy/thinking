package _ws.jaxws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
	public static void main(String[] args) {
		try {
			QName sQname = new QName("http://jaxws._ws/", "HelloWorldImpService");
			URL sUrl = new URL("http://localhost:8888/helloWorld?wsdl");
			
			Service service = Service.create(sUrl, sQname);
			HelloWorld hw = service.getPort(HelloWorld.class);
			
			System.out.println(hw.sayHi("123"));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
}
