package _ws.jaxws;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


@WebService
public interface HelloWorld {
	public @WebResult(name="result") String sayHi(@WebParam(name="name") String name);
}
