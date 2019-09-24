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


    //用户登录
    // @ResponseBody
    //@RequestMapping(value="/login",method=RequestMethod.GET)
    //public Object login(@RequestParam(value = "loginName") String loginName,
    //					@RequestParam(value = "password") String password){
    //	for(User User : sList) {
    //		if(User.getLoginName().equals(loginName)&&User.getPassword().equals(password)) {
    //			System.out.println(loginName + " : login !"); 
    //			return "success";
    //		}
    //	}
    //	System.out.println(loginName + "/" + password + " : login faild!"); 
    //   return "faild";
    //}

    //查询所有
    @ResponseBody
    @RequestMapping(value="/user",method=RequestMethod.GET)
    public Object getAll(){
        System.out.println("GET:ALL"); 
        List<SysUser> users= userserivce.getAllUsers();
        return users;
    }
    //查询单个
    @ResponseBody
    @RequestMapping(value="/user/{name}",method=RequestMethod.GET)
    public Object getOne(@PathVariable("name") String name){
        System.out.println("GET:"+name);
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
    	userserivce.saveUser(user);
        System.out.println("POST:"+user.getName());
        //sList.add(User);
        return user;
    }

    //修改
//    @ResponseBody
//    @RequestMapping(value="/user/{name}",method=RequestMethod.PUT)
//    public Object put(@PathVariable("name") String name,@RequestBody SysUser User){
//        System.out.println("PUT:"+name);
//        List<SysUser> removeList = new ArrayList<SysUser>();
//        for (SysUser s : sList) {
//            if(s.getName().equals(name)){
//                User.setName(s.getName());
//                removeList.add(s);  
//            }
//        }
//        sList.removeAll(removeList);
//        sList.add(User);
//        return sList;
//    }
//
//    //删除所有
//    @ResponseBody
//    @RequestMapping(value="/user",method=RequestMethod.DELETE)
//    public Object delete(){
//        System.out.println("DELETE:ALL");
//        sList.clear();
//        return sList;
//    }
//
//    //删除单个
//    @ResponseBody
//    @RequestMapping(value="/user/{name}",method=RequestMethod.DELETE)
//    public Object delete(@PathVariable("name") String name){
//        System.out.println("DELETE:"+name);
//        List<SysUser> removeList = new ArrayList<SysUser>();
//        for (SysUser s : sList) {
//            if(s.getName().equals(name)){
//                removeList.add(s);  
//            }
//        }
//        sList.removeAll(removeList);
//        return sList;
//    }

}