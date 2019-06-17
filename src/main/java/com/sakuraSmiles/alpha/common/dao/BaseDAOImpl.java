package com.sakuraSmiles.alpha.common.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class BaseDAOImpl implements IBaseDAO {
	@Resource
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<?> queryForList(String sql) {
		System.out.println("执行语句：" + sql);
		List<?> list = this.jdbcTemplate.queryForList(sql);
        return list;
	}
	@Override
	public List<?> queryForList(String sql, Object[] args) {
		System.out.println("执行语句：" + sql);
		List<?> list = this.jdbcTemplate.queryForList(sql,args);
        return list;
	}
	@Override
	public Map<?, ?> queryForMap(String sql, Object[] args) {
		System.out.println("执行语句：" + sql);
        Map<?, ?> map = this.jdbcTemplate.queryForMap(sql, args);
        return map;
	}

}
