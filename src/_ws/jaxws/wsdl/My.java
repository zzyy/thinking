package _ws.jaxws.wsdl;

import javax.jws.WebService;

@WebService(endpointInterface="_ws.jaxws.wsdl.MyService",name = "MyService",
			targetNamespace = "http://www.example.org/MyService/",
			wsdlLocation="_ws/jaxws/wsdl/MyService.wsdl")
public class My implements MyService {

	@Override
	public int add(int a, int b) {
		System.out.println("a+b");
		return a+b;
	}

}
