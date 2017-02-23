package com.tang.collection;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Test;

import com.tang.fc.HibernateSessionFactory;

@SuppressWarnings("deprecation")
public class App {
	
	private static SessionFactory sf;
	
	static{
		sf=new Configuration().configure().buildSessionFactory();
	}

//   @Test
	public void testSaveSet(){
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Set<String> addressSet= new HashSet<String>();
		addressSet.add("四川");
		addressSet.add("重庆");
		
		User user = new User();
		user.setUserName("Jack");
		user.setAddress(addressSet);
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}
	
//	@Test
	public void testSaveMap(){
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		
		User user = new User();
		user.setUserName("Tom");
		
		user.getAddressMap().put("No.1", "四川达州");
		user.getAddressMap().put("No.2", "四川成都");
		
		session.save(user);
		session.getTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
	
//	@Test
	public void testSaveList(){
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		
		User user = new User();
		user.setUserName("Jerry");
		
		user.getAddressList().add("英国伦敦");
		user.getAddressList().add("美国洛杉矶");
		
		session.save(user);
		session.getTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
	
	//@Test
	public void testGet(){
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		
		User user=(User)session.get(User.class, 1);
		System.out.println("UserId:"+user.getUserId());
		System.out.println("UserName:"+user.getUserName());
		
		session.getTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}






















