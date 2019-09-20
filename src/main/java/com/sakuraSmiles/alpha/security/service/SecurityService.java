package com.sakuraSmiles.alpha.security.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sakuraSmiles.alpha.security.repository.SysUserRepository;
import com.sakuraSmiles.alpha.security.model.SysUser;

@Service
@Transactional
public class SecurityService implements UserDetailsService  {
	@Autowired
    SysUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
		SysUser user = userRepository.findByLoginName(ssoId);
		if (user == null) {
			user = userRepository.findByPhone(ssoId);
			if (user == null) {
				user = userRepository.findByEmail(ssoId);
				if (user == null) {
					throw new UsernameNotFoundException("该用户不存在！");
				} else {
					System.out.println("email:" + ssoId);
				}
			} else {
				System.out.println("phone:" + ssoId);
			}
		} else {
			System.out.println("loginName:" + ssoId);
		}
		System.out.println("userName:" + user.getName() + ";password:" + user.getPassword());
		return user;
	}
}
