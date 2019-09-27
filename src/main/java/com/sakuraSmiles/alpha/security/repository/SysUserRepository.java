package com.sakuraSmiles.alpha.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sakuraSmiles.alpha.security.model.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
	SysUser findByLoginName(String loginname);

	SysUser findByPhone(String phone);

	SysUser findByEmail(String email);
	
	@Query(value ="SELECT max(uid) from sys_user", nativeQuery = true)
    Long getMaxUid();
	
	@Query(value ="SELECT count(1) from sys_user", nativeQuery = true)
    int getUserCount();
	
	
}
