/**
 * 用户模型
 */
package com.sakuraSmiles.alpha.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SecondaryTable;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@SecondaryTable(name="sys_user_extend")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class SysUser implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SysUser() {
	}

	// 此方法会将默认的无参构造方法给覆盖掉，必须加上上面的无参构造方法
	public SysUser(String loginName, String password) {
		super();
		this.loginName = loginName;
		this.password = password;
	}

	@Id
	@GeneratedValue(generator = "jpa-uuid")
	private String id;
	@Column(unique=true)
	private Long uid;
	@Column(unique=true ,nullable = false)
	private String loginName;
	@Column(nullable = false)
	private String password;
	@Column(unique=true ,nullable = false)
	private String name;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String phone;
	@Column
	private String remark;
	@Column
	private String lastLoginTime;
	@Column
	private String lastLoginIp;
	@Column
	private String currentLoginTime;
	@Column
	private String currentLoginIp;
	@Column(nullable = false)
	private String isActive = "true";
	@Column(table="sys_user_extend")
	private String level;
	@Column(table="sys_user_extend")
	private String currentExperience;
	@Column(table="sys_user_extend")
	private String totalExperience;
	@ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	private List<SysRole> roles;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getCurrentLoginTime() {
		return currentLoginTime;
	}

	public void setCurrentLoginTime(String currentLoginTime) {
		this.currentLoginTime = currentLoginTime;
	}

	public String getCurrentLoginIp() {
		return currentLoginIp;
	}

	public void setCurrentLoginIp(String currentLoginIp) {
		this.currentLoginIp = currentLoginIp;
	}

	public String getCurrentExperience() {
		return currentExperience;
	}

	public void setCurrentExperience(String currentExperience) {
		this.currentExperience = currentExperience;
	}

	public String getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		List<SysRole> roles = this.roles;
		for (SysRole role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		return this.getLoginName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}