package _ws.jaxws;

import javax.jws.WebService;

@WebService(name="helloWorld" ,
			endpointInterface="_ws.jaxws.HelloWorld")
public class HelloWorldImp implements HelloWorld {

	@Override
	public String sayHi(String name) {
		return name + ": hi";
	}

}
