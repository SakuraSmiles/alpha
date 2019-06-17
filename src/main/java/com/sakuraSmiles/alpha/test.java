package com.sakuraSmiles.alpha;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class test{
  private static final Logger logger = LoggerFactory.getLogger(test.class);
  @Autowired
  private JdbcTemplate jdbcTemplate;
  @RequestMapping("hello")
  public List<Map<String, Object>> hello() {
    List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * from je_core_enduser ", new Object[]{});
    System.out.println(list.toString());
    return list;
  }
}
