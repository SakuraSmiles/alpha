package com.groupA.alpha.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.groupA.alpha.common.model.User;



@Controller

public class CoreController {
	String message = "Welcome to Spring MVC!";
	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public @ResponseBody User getUserInJSON() {
		System.out.println("-----ÇëÇójsonÊý¾Ý--------");
		User user = new User();
		user.setName("hello");
		user.setPassword("123456");
		return user;
    }
}