package _spring_hibernate;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import _hibernate.pojo.Category;
import _hibernate.pojo.Goods;

public class DaoSupport extends HibernateDaoSupport {

	public void loadAll(){
		HibernateTemplate template = this.getHibernateTemplate();
		
		List<Category> categories = template.loadAll(Category.class);
		for(int i=0, size=categories.size(); i<size; i++){
			System.out.println(categories.get(i));
		}
	}
	
	public void add() {
//		Session session = this.getSession();
//		session.beginTransaction();
		
		HibernateTemplate template = this.getHibernateTemplate();
		
		Category category = new Category(1,"zy");
		Goods goods = new Goods();
		goods.setId(0).setName("bag").setCategory(category);
		template.save(category);
		template.save(goods);
	}
}
