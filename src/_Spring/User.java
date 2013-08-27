package _Spring;

public class User {
	private int id, age;
	private String name;
	public User(int id, int age, String name) {
		System.out.println("----user constructor----");
		this.id = id;
		this.age = age;
		this.name = name;
	}
	
	public void init() {
		System.out.println(">>>user init()");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
