package com.tang.oneToM;

import org.hibernate.Session;
import org.junit.Test;

import com.tang.fc.HibernateSessionFactory;

/**
 * Inverse���ԣ�����ά��������ϵ��ʱ�������õġ�
        ��ʾ����Ȩ�Ƿ�ת�ơ�(��һ��һ��������)

   Inverse , ���Ʒ�ת��
   Inverse = false  ����ת��   ��ǰ���п���Ȩ
   True  ���Ʒ�ת�� ��ǰ��û�п���Ȩ
 */
public class TestInverse {

	
	//@Test
	public void saveFromDept(){
		
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setDeptName("�ۺϲ�");
		
		Employee emp1 = new Employee();
		emp1.setEmpName("���ϴ�");
		Employee emp2 = new Employee();
		emp2.setEmpName("л�϶�");
		
		
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
		dept.setDeptName("����");
		
		Employee emp1 = new Employee();
		emp1.setEmpName("��Ӱ");
		Employee emp2 = new Employee();
		emp2.setEmpName("����");
		
		emp1.setDept(dept);
		emp2.setDept(dept);
		
		session.save(dept);
		session.save(emp1);
		session.save(emp2);
		session.getTransaction().commit();
		HibernateSessionFactory.closeSession();
		
	}
}
