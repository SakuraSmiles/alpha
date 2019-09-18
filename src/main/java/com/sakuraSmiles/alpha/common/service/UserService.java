package com.sakuraSmiles.alpha.common.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sakuraSmiles.alpha.security.model.SysUser;
import com.sakuraSmiles.alpha.security.repository.SysUserRepository;

public class UserService {
	@Autowired
    SysUserRepository userRepository;
	
	public void saveUser(SysUser user) {
		userRepository.save(user);
	}

}
