package _ws.jaxws;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class Client {
	public static void main(String[] args) {
		QName seviceName = new QName("http://jaxws._ws/", "helloWorld");
		Service service = Service.create(seviceName);
		
		String endpointAdress = "http://localhost:8888/helloWorld";
		QName portName = new QName("http://jaxws._ws/", "helloWorldPort");
		service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, endpointAdress);
		
		HelloWorld client = service.getPort(HelloWorld.class);
		System.out.println(client.sayHi("asd"));
	}
}
