package _hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Goods")
public class Goods {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@ManyToOne
	@JoinColumn
	private Category category;
	
	public int getId() {
		return id;
	}
	public Goods setId(int id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public Goods setName(String name) {
		this.name = name;
		return this;
	}
	public Category getCategory() {
		return category;
	}
	public Goods setCategory(Category category) {
		this.category = category;
		return this;
	}
	
	
}
