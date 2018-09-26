package com.groupA.alpha.common.model;

public class User {
	String name;
	String password;
	
	public User() {
	}

	//此方法会将默认的无参构造方法给覆盖掉，必须加上上面的无参构造方法
	public User(String name, String password) {
		super();
	    this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}