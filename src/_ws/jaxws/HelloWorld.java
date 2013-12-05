package _ws.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


@WebService

public interface HelloWorld {
	@WebMethod(operationName="hi")
	public @WebResult(name="result") String sayHi(@WebParam(name="name") String name) throws Exception;
	
	public Pojo getName(Pojo p) throws Exception;
}
