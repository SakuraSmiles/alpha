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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userRepository.findByLoginName(username);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在！");
        }
        System.out.println("loginName:"+username);
        System.out.println("userName:"+user.getName()+";password:"+user.getPassword());
        return user;
    }
}
