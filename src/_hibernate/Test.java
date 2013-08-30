package _hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import _hibernate.pojo.Category;

public class Test {

	@org.junit.Test
	public void createDB(){
		Configuration cfg = new Configuration().configure("./_hibernate/hibernate.cfg.xml");
		SchemaExport export = new SchemaExport(cfg);
		export.create(true, true);
	}
	
	@org.junit.Test
	public void insert(){
		Configuration cfg = new Configuration().configure("./_hibernate/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Category category1 = new Category(1, "qwe");
		session.save(category1);
		tx.commit();

		tx = session.beginTransaction();
		category1.setName("rty");
		session.save(category1);
		category1.setName("uio");
		session.save(category1);
		
		Category category2 = new Category(1, "asd");
		session.save(category2);
		
		tx.commit();
	}
}
