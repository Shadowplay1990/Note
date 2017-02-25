package com.tang.MtoM;

import java.util.HashSet;
import java.util.Set;

public class Pro {

	private int proId;
	private String proName;
	
	private Set<Dep> deps=new HashSet<Dep>();

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Set<Dep> getDeps() {
		return deps;
	}

	public void setDeps(Set<Dep> deps) {
		this.deps = deps;
	}
	
}
