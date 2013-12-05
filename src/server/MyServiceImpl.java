package server;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface="server.IMyService",targetNamespace="http://www.example.org/zy/",
			serviceName="MyService",portName="MyServiceSOAP",
			wsdlLocation="wsdl/MyWSDLFile.wsdl")
public class MyServiceImpl implements IMyService {

	@Override
	public boolean add(User user) {
		System.out.println("id:"+user.getId() +" name:"+user.getName()+" gender:"+user.isGender());
		return true;
	}

	@Override
	public List<User> list() {
		List<User> users = new ArrayList<>();
		users.add(new User(1,"z",false));
		users.add(new User(2,"x",false));
		users.add(new User(3,"c",true));
		return users;
	}

}
