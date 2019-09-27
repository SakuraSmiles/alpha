/**
 * 核心控制类
 * 
 */
package com.sakuraSmiles.alpha.common.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sakuraSmiles.alpha.common.service.UserService;
import com.sakuraSmiles.alpha.security.model.SysUser;


@Controller
@RequestMapping("/api")
public class APIUserController {

	@Autowired
	UserService userserivce;

    //查询所有
    @ResponseBody
    @RequestMapping(value="/user",method=RequestMethod.GET)
    public Object getAll(){
        List<SysUser> users= userserivce.getAllUsers();
        return users;
    }
    //查询单个
    @ResponseBody
    @RequestMapping(value="/user/{name}",method=RequestMethod.GET)
    public Object getOne(@PathVariable("name") String name){
        SysUser user = userserivce.getUserByLoginname(name);
        return user;
    }

    //添加
    @ResponseBody
    @RequestMapping(value="/user",method=RequestMethod.POST)
    public Object post(@RequestBody SysUser user){
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String encodedPassword  = passwordEncoder.encode(user.getPassword());
    	user.setPassword(encodedPassword);
    	Long uid = userserivce.getMaxUid() +1;
    	user.setUid(uid);
    	userserivce.saveUser(user);
        return user;
    }
//    //删除单个
//    @ResponseBody
//    @RequestMapping(value="/user/{name}",method=RequestMethod.DELETE)
//    public Object delete(@PathVariable("name") String name){
//        SysUser user = userserivce.getUserByLoginname(name);
//        if(user==null) {
//        	return "{\"status\":\"false\"}";
//        }
//        userserivce.deleteUser(user);
//        return "{\"status\":\"true\"}";
//    }

    //修改
    @ResponseBody
    @RequestMapping(value="/user",method=RequestMethod.PUT)
    public Object put(@RequestBody SysUser user){
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String encodedPassword  = passwordEncoder.encode(user.getPassword());
    	user.setPassword(encodedPassword);
    	userserivce.saveUser(user);
        return user;
    }

}