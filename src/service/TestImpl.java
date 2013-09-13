package service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="TestImpl",portName="port",
			endpointInterface="service.ITest",
			wsdlLocation="wsdl/test.wsdl",
			targetNamespace = "http://www.example.org/zy/")
public class TestImpl implements ITest {

	public String fn(
			@WebParam(name = "param", targetNamespace = "") String param,
			@WebParam(name = "otherArg", targetNamespace = "") int otherArg) {
		System.out.println("+++++++++++++");
		return param+otherArg;
	}

}
