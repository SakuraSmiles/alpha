package com.sakuraSmiles.alpha.common.config.datasouce;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
 
import javax.sql.DataSource;
import java.sql.SQLException;
 
/**
 * druid连接池配置类
 */
public class DruidSource {
    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSource() throws SQLException {
    	return DruidDataSourceBuilder.create().build();
    }
}
