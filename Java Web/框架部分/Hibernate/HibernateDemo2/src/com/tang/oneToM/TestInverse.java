package com.tang.oneToM;

import org.hibernate.Session;
import org.junit.Test;

import com.tang.fc.HibernateSessionFactory;

/**
 * Inverse属性，是在维护关联关系的时候起作用的。
        表示控制权是否转移。(在一的一方起作用)

   Inverse , 控制反转。
   Inverse = false  不反转；   当前方有控制权
   True  控制反转； 当前方没有控制权
 */
public class TestInverse {

	
	//@Test
	public void saveFromDept(){
		
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setDeptName("综合部");
		
		Employee emp1 = new Employee();
		emp1.setEmpName("王老大");
		Employee emp2 = new Employee();
		emp2.setEmpName("谢老二");
		
		
		dept.getEmployees().add(emp1);
		dept.getEmployees().add(emp2);
		
		session.save(emp1);
		session.save(emp2);
		session.save(dept);
		
		session.getTransaction().commit();
		HibernateSessionFactory.closeSession();
		
	}
	
	
	//@Test
	public void saveFromEmp(){
		
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setDeptName("财务部");
		
		Employee emp1 = new Employee();
		emp1.setEmpName("唐影");
		Employee emp2 = new Employee();
		emp2.setEmpName("唐曼");
		
		emp1.setDept(dept);
		emp2.setDept(dept);
		
		session.save(dept);
		session.save(emp1);
		session.save(emp2);
		session.getTransaction().commit();
		HibernateSessionFactory.closeSession();
		
	}
}
