/**
 * 用户模型
 */
package com.sakuraSmiles.alpha.common.model;

public class User {
	private String id;
	private String loginName;
	private String password;
	private String name;
	private String email;
	private String phone;
	
	public User() {
	}

	//此方法会将默认的无参构造方法给覆盖掉，必须加上上面的无参构造方法
	public User(String name, String password) {
		super();
	    this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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