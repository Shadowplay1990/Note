package com.tang.oneToM;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.tang.fc.HibernateSessionFactory;

public class GetTest {
	
	//@Test
	public void get(){
		
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		
		/*Dept dept=(Dept) session.get(Dept.class, 3);
		System.out.println("DeptName:"+dept.getDeptName());
		
		Set<Employee> employees = dept.getEmployees();
		for (Employee emp:employees) {
			System.out.println("EmployeeName:"+emp.getEmpName()+"\n"+"EmployeeSalary:"+emp.getSalary());
		}*/
		
		Employee emp=(Employee) session.get(Employee.class, 3);
		System.out.println("EmployeeName:"+emp.getEmpName()+"\n"+"EmployeeSalary:"+emp.getSalary());
		
		Dept dept = emp.getDept();
		System.out.println("DeptName:"+dept.getDeptName());
	}
}





























