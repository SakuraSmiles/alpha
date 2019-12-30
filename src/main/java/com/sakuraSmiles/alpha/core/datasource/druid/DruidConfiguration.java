package com.sakuraSmiles.alpha.core.datasource.druid;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import javax.sql.DataSource;
import java.sql.SQLException;
 
/**
 * druid连接池配置类
 */
@Configuration
public class DruidConfiguration {
    @Bean(initMethod = "init",destroyMethod = "close")     //声明其为Bean实例
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSource() throws SQLException {
    	DruidDataSource  datasource = new DruidDataSource();
    	return datasource;
    }
    @Bean
    public Filter statFilter() {
        StatFilter filter = new StatFilter();
        filter.setSlowSqlMillis(5000);
        filter.setLogSlowSql(true);
        filter.setMergeSql(true);
        return filter;
    }
    /**
     * 	注册一个：filterRegistrationBean
     * @return
     */
    
    @Bean
    public FilterRegistrationBean<WebStatFilter> druidStatFilter(){
       FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>(new WebStatFilter());
 
       //添加过滤规则.
       filterRegistrationBean.addUrlPatterns("/*");
 
       //添加不需要忽略的格式信息.
       filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
 
       return filterRegistrationBean;
    }
    /**
     *	 注册一个StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> DruidStatViewServle(){
 
       //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
       ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(),"/druid/*");
 
       //添加初始化参数：initParams
 
       //白名单：
       servletRegistrationBean.addInitParameter("allow","127.0.0.1");
 
       //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
       //servletRegistrationBean.addInitParameter("deny","192.168.0.114");
 
       //登录查看信息的账号密码.
       servletRegistrationBean.addInitParameter("loginUsername","wangchb");
       servletRegistrationBean.addInitParameter("loginPassword","123456");
 
       //是否能够重置数据.
       servletRegistrationBean.addInitParameter("resetEnable","false");
       return servletRegistrationBean;
    }
}
