package com.sakuraSmiles.alpha.common.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDAO {
	public List<?> queryForList(String sql);
	public List<?> queryForList(String sql, Object[] args);
    public Map<?, ?> queryForMap(String sql,Object[] args);
}
