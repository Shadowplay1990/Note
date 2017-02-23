package com.tang.MtoM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.tang.fc.HibernateSessionFactory;

public class SaveTest {
	
	private static SessionFactory sf;
	static{
		sf=new Configuration().configure().buildSessionFactory();
	}

	@Test
	public void testSave(){
		Session session = sf.openSession();
		session.beginTransaction();
		
		Dep dep = new Dep();
		dep.setDepName("�ƾü�");
		Dep dep2 = new Dep();
		dep2.setDepName("������");
		Dep dep3 = new Dep();
		dep3.setDepName("������");
		
		Pro pro = new Pro();
		pro.setProName("�ֲ�ʽϵͳ");
		Pro pro2 = new Pro();
		pro2.setProName("OAϵͳ");
		
		pro.getDeps().add(dep);
		pro.getDeps().add(dep2);
		pro.getDeps().add(dep3);
		
		session.save(dep);
		session.save(dep2);
		session.save(dep3);
		
		session.save(pro);
		session.save(pro2);
		
		session.getTransaction().commit();
		session.close();
	}
}

























