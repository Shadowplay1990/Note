package com.tang.oneToM;

import java.util.HashSet;
import java.util.Set;

public class Dept {

	private int deptId;
	private String deptName;
	
	//一对多，一个部门对应多个员工
	private Set<Employee> employees=new HashSet<Employee>();

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
