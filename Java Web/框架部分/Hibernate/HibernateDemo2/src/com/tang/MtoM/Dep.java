package com.tang.MtoM;

import java.util.HashSet;
import java.util.Set;

public class Dep {

	private int DepId;
	private String DepName;
	
	//开发人员参与多个项目
	private Set<Pro> pros=new HashSet<Pro>();

	public int getDepId() {
		return DepId;
	}

	public void setDepId(int depId) {
		DepId = depId;
	}

	public String getDepName() {
		return DepName;
	}

	public void setDepName(String depName) {
		DepName = depName;
	}

	public Set<Pro> getPros() {
		return pros;
	}

	public void setPros(Set<Pro> pros) {
		this.pros = pros;
	}
	
}
