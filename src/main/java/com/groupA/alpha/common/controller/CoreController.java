/**
 * 核心控制类
 * 
 */
package com.groupA.alpha.common.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.groupA.alpha.common.model.User;



@Controller
@RequestMapping("/core")
public class CoreController {
	//存储用户信息
    private List<User> sList = new ArrayList<User>();

    //初始化
    public CoreController(){
        User s1 = new User("Sakura_Smile","123456");
        User s2 = new User("loginName2","123");
        User s3 = new User("loginName3","123");
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
    }
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
        List<User> selectList = new ArrayList<User>();
        for(User s : sList){
            if(s.getName().equals(name)){
                selectList.add(s);
            } 
        }
        return selectList;
    }

    //添加
    @ResponseBody
    @RequestMapping(value="/user",method=RequestMethod.POST)
    public Object post(@RequestBody User user){
        System.out.println("POST:"+user.getName());
        sList.add(user);
        return sList;
    }

    //修改
    @ResponseBody
    @RequestMapping(value="/user/{name}",method=RequestMethod.PUT)
    public Object put(@PathVariable("name") String name,@RequestBody User user){
        System.out.println("PUT:"+name);
        List<User> removeList = new ArrayList<User>();
        for (User s : sList) {
            if(s.getName().equals(name)){
                user.setName(s.getName());
                removeList.add(s);  
            }
        }
        sList.removeAll(removeList);
        sList.add(user);
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
        List<User> removeList = new ArrayList<User>();
        for (User s : sList) {
            if(s.getName().equals(name)){
                removeList.add(s);  
            }
        }
        sList.removeAll(removeList);
        return sList;
    }

}