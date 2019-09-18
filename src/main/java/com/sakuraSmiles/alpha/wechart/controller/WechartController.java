package com.sakuraSmiles.alpha.wechart.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class WechartController{
  private static final Logger logger = Logger.getLogger(WechartController.class);
  @Value("${wechart.appid}")
  private String appid;
  @Value("${wechart.secret}")
  private String secret;
  @Autowired
  private JdbcTemplate jdbcTemplate;
  @RequestMapping("hello")
  public List<Map<String, Object>> hello() {
    List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * from je_core_enduser ", new Object[]{});
    System.out.println(list.toString());
    return list;
  }
  //微信用户登录认证
  @ResponseBody
  @RequestMapping(value="/jscode2session",method=RequestMethod.GET)
  public Object getOne(@RequestParam(value = "code") String code){
	  logger.info(getClass().getSimpleName());
	  RestTemplate restTemplate=new RestTemplate();
	  HttpHeaders headers = new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	  HttpEntity<String> entity = new HttpEntity<String>(headers);
	  String uri="https://api.weixin.qq.com/sns/jscode2session?appid="+this.appid+"&secret="+this.secret+"&js_code="+code+"&grant_type=authorization_code";
	  
	  String strbody=restTemplate.exchange(uri, HttpMethod.GET, entity,String.class).getBody();
	  System.out.println(uri);
	  System.out.println(strbody);
      return strbody;
  }
  
}
