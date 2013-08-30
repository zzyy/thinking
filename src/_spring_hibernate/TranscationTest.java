package _spring_hibernate;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import _hibernate.pojo.Category;
import _hibernate.pojo.Goods;
@Component
public class TranscationTest {
	private HibernateTemplate template = null;
	@Resource(name="hibernateTemplate")
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public void add() {
		Category category = new Category(1,"zy");
		Goods goods = new Goods();
		goods.setId(0).setName("bag").setCategory(category);
		template.save(category);
		template.save(goods);
	} 
}
