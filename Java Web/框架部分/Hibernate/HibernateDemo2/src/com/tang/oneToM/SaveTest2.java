package com.tang.oneToM;

import org.hibernate.Session;
import org.junit.Test;

import com.tang.fc.HibernateSessionFactory;

public class SaveTest2 {

	/**
	 * һ����������ű�һ���ж࣬һΪ����Ϊ�ӡ�ͨһ��࣬�ȱ����һ��
	 */
	//@Test
	public void saveFromDept(){
		
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setDeptName("���۲�");
		
		Employee emp1 = new Employee();
		emp1.setEmpName("��Ƥ");
		Employee emp2 = new Employee();
		emp2.setEmpName("�θ�");
		
		//��������þ�employee�����
		dept.getEmployees().add(emp1);
		dept.getEmployees().add(emp2);
		
		session.save(emp1);
		session.save(emp2);
		session.save(dept);
		
		session.getTransaction().commit();
		HibernateSessionFactory.closeSession();
		
		/*Hibernate: 
		    insert 
		    into
		        employee
		        (empName, salary, deptId) 
		    values
		        (?, ?, ?)
		Hibernate: 
		    insert 
		    into
		        employee
		        (empName, salary, deptId) 
		    values
		        (?, ?, ?)
		Hibernate: 
		    insert 
		    into
		        dept
		        (deptName) 
		    values
		        (?)*/
		
		 /*'CREATE TABLE `employee` 
		(\n  `empId` int(11) NOT NULL AUTO_INCREMENT,\n 
				`empName` varchar(25) DEFAULT NULL,\n  
				`salary` double DEFAULT NULL,\n 
				`deptId` int(11) DEFAULT NULL,\n  
				PRIMARY KEY (`empId`),\n  
				KEY `FK4722E6AEDB29EC0C` (`deptId`),\n 
				CONSTRAINT `FK4722E6AEDB29EC0C` FOREIGN KEY (`deptId`) REFERENCES `dept` (`deptId`)\n) 
				ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8'
*/
	}
	
	/**
	 *һ����������ű�������һ��ͨ����һ���ȱ����һ�� 
	 */
	//@Test
	public void saveFromEmp(){
		
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setDeptName("����");
		
		Employee emp1 = new Employee();
		emp1.setEmpName("����Ӱ");
		Employee emp2 = new Employee();
		emp2.setEmpName("��С��");
		
		emp1.setDept(dept);
		emp2.setDept(dept);
		
		session.save(dept);
		session.save(emp1);
		session.save(emp2);
		session.getTransaction().commit();
		HibernateSessionFactory.closeSession();
		
/*		Hibernate: 
		    insert 
		    into
		        dept
		        (deptName) 
		    values
		        (?)
		Hibernate: 
		    insert 
		    into
		        employee
		        (empName, salary, deptId) 
		    values
		        (?, ?, ?)
		Hibernate: 
		    insert 
		    into
		        employee
		        (empName, salary, deptId) 
		    values
		        (?, ?, ?)*/
	}
}



















