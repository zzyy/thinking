package service;

import javax.xml.ws.Endpoint;

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/zy", new TestImpl());
	}

}
