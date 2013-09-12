package _ws.jaxws.wsdl;

import javax.xml.ws.Endpoint;

public class Server {

	public static void main(String[] args) {
		
		Endpoint.publish("http://localhost:8888/zy", new My());
	}

}
