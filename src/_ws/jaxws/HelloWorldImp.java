package _ws.jaxws;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(endpointInterface="_ws.jaxws.HelloWorld")
@HandlerChain(file="_ws/jaxws/handler-chain.xml")
public class HelloWorldImp implements HelloWorld {

	@Override
	public String sayHi(String name) {
		System.out.println();
		System.out.println(name + ": hi");
		return name + ": hi";
	}

	@Override
	public String getName() throws Exception {
		throw new Exception("***exception**");
	}

}
