package _XML;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class Po {
	private int id;
	private String name;
	private Boolean status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Po() {}
	public Po(int id, String name, Boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
}
