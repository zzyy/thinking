package _Spring;

public class Target {

	private User user;

	public void setUser(User user) {
		this.user = user;
	}
	
	public void display(){
		System.out.println("----target.display()" + user.getId() );
	}
}
