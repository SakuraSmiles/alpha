/**
 * 核心控制类
 * 
 */
package com.sakuraSmiles.alpha.common.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sakuraSmiles.alpha.common.service.UserService;


@Controller
public class CoreController {
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
    //展示首页
    @ResponseBody
    @RequestMapping(value="index")
    public ModelAndView showIndex(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}