package com.sakuraSmiles.alpha.common.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakuraSmiles.alpha.security.model.SysUser;
import com.sakuraSmiles.alpha.security.repository.SysUserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
    SysUserRepository userRepository;
	
	public void saveUser(SysUser user) {
		userRepository.save(user);
	}
	public boolean deleteUser(SysUser user) {
		userRepository.delete(user);
		return true;
	}
	public List<SysUser> getAllUsers() {
		return userRepository.findAll();
	}
	public SysUser getUserByLoginname(String loginname) {
		return userRepository.findByLoginName(loginname);
	}
	public SysUser getUserByPhone(String phone) {
		return userRepository.findByPhone(phone);
	}
	public SysUser getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	public Long getMaxUid() {
		return userRepository.getMaxUid();
	}
	public int getUserCount(){
		return userRepository.getUserCount();
	}
}
