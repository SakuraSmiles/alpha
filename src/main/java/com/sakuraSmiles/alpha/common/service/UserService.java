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
	public List<SysUser> getAllUsers() {
		return userRepository.findAll();
	}
	public SysUser getUserByLoginname(String loginname) {
		return userRepository.findByLoginName(loginname);
	}

}
