/**
 * 核心控制类
 * 
 */
package com.sakuraSmiles.alpha.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sakuraSmiles.alpha.common.service.UserService;


@Controller
public class CoreController {
	@Value("${application.version}")//后台版本号
	String version;
	@Value("${application.status}")//后台状态，可在配置文件中修改
	String status;
	
	@Autowired
	UserService userserivce;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("hello")
	public List<Map<String, Object>> hello() {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * from sys_user ", new Object[] {});
		System.out.println(list.toString());
		return list;
	}
    //为首页提供后台服务基本相关信息
    @ResponseBody
    @RequestMapping(value="index",method=RequestMethod.GET)
    public Object getPlatformMsg(){
    	HashMap<String,Object> platform=new HashMap<>();
    	platform.put("version", version);
    	platform.put("status", status);
        return platform;
    }
    //展示首页
//    @ResponseBody
//    @RequestMapping(value="index")
//    public ModelAndView showIndex(){
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("index");
//        return mav;
//    }
}