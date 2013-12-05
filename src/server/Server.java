package server;

import javax.xml.ws.Endpoint;

public class Server {

	public static void main(String[] args) {
		Endpoint.publish("http://www.localhost:8989/zy/", new MyServiceImpl());
	}

}
