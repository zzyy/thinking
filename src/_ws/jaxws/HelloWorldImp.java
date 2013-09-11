package _ws.jaxws;

import javax.jws.WebService;

@WebService(endpointInterface="_ws.jaxws.HelloWorld")
public class HelloWorldImp implements HelloWorld {

	@Override
	public String sayHi(String name) {
		System.out.println(name + ": hi");
		return name + ": hi";
	}

}
