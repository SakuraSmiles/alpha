package com.sakuraSmiles.alpha.security.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakuraSmiles.alpha.security.model.SysMenu;
import com.sakuraSmiles.alpha.security.repository.SysMenuRepository;

@Service
@Transactional
public class MenuService {
	@Autowired
    SysMenuRepository menuRepository;
	public List<SysMenu> getAllMenu(){
		List<SysMenu> menuList =menuRepository.findAll();
		return menuList;
	}
}
