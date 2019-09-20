package com.sakuraSmiles.alpha.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakuraSmiles.alpha.security.model.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
	SysUser findByLoginName(String loginname);

	SysUser findByPhone(String phone);

	SysUser findByEmail(String email);
}
