package com.tang.oneToM;

import org.hibernate.Session;
import org.junit.Test;

import com.tang.fc.HibernateSessionFactory;

public class SaveTest2 {

	/**
	 * 一个外键，两张表。一里有多，一为主多为从。通一设多，先保多后保一。
	 */
	//@Test
	public void saveFromDept(){
		
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setDeptName("销售部");
		
		Employee emp1 = new Employee();
		emp1.setEmpName("嘉皮");
		Employee emp2 = new Employee();
		emp2.setEmpName("嘉哥");
		
		//如果不设置就employee无外键
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
	 *一个外键，两张表。多里有一，通多设一，先保多后保一。 
	 */
	//@Test
	public void saveFromEmp(){
		
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setDeptName("财务部");
		
		Employee emp1 = new Employee();
		emp1.setEmpName("唐无影");
		Employee emp2 = new Employee();
		emp2.setEmpName("唐小曼");
		
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



















