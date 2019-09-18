/**
 * 核心控制类
 * 
 */
package com.sakuraSmiles.alpha.common.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sakuraSmiles.alpha.common.service.UserService;
import com.sakuraSmiles.alpha.security.model.SysUser;


@Controller
public class CoreController {
	//存储用户信息
    private List<SysUser> sList = new ArrayList<SysUser>();
    
    UserService userserivce ;
    //展示首页
    @ResponseBody
    @RequestMapping(value="index")
    public ModelAndView showIndex(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
    //初始化
    public CoreController(){
        SysUser s1 = new SysUser("Sakura_Smile","123456");
        SysUser s2 = new SysUser("loginName2","123");
        SysUser s3 = new SysUser("loginName3","123");
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
    }
    //用户登录
    // @ResponseBody
    //@RequestMapping(value="/login",method=RequestMethod.GET)
    //public Object login(@RequestParam(value = "loginName") String loginName,
    //					@RequestParam(value = "password") String password){
    //	for(SysUser SysUser : sList) {
    //		if(SysUser.getLoginName().equals(loginName)&&SysUser.getPassword().equals(password)) {
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
        return sList;
    }
    //查询单个
    @ResponseBody
    @RequestMapping(value="/user/{name}",method=RequestMethod.GET)
    public Object getOne(@PathVariable("name") String name){
        System.out.println("GET:"+name);
        List<SysUser> selectList = new ArrayList<SysUser>();
        for(SysUser s : sList){
            if(s.getName().equals(name)){
                selectList.add(s);
            } 
        }
        return selectList;
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
        //sList.add(SysUser);
        return sList;
    }

    //修改
    @ResponseBody
    @RequestMapping(value="/user/{name}",method=RequestMethod.PUT)
    public Object put(@PathVariable("name") String name,@RequestBody SysUser SysUser){
        System.out.println("PUT:"+name);
        List<SysUser> removeList = new ArrayList<SysUser>();
        for (SysUser s : sList) {
            if(s.getName().equals(name)){
                SysUser.setName(s.getName());
                removeList.add(s);  
            }
        }
        sList.removeAll(removeList);
        sList.add(SysUser);
        return sList;
    }

    //删除所有
    @ResponseBody
    @RequestMapping(value="/user",method=RequestMethod.DELETE)
    public Object delete(){
        System.out.println("DELETE:ALL");
        sList.clear();
        return sList;
    }

    //删除单个
    @ResponseBody
    @RequestMapping(value="/user/{name}",method=RequestMethod.DELETE)
    public Object delete(@PathVariable("name") String name){
        System.out.println("DELETE:"+name);
        List<SysUser> removeList = new ArrayList<SysUser>();
        for (SysUser s : sList) {
            if(s.getName().equals(name)){
                removeList.add(s);  
            }
        }
        sList.removeAll(removeList);
        return sList;
    }

}