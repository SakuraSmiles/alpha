package com.sakuraSmiles.alpha.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class springMvcConfiguration extends WebMvcConfigurationSupport  {
	private final static Logger logger = LoggerFactory.getLogger(springMvcConfiguration.class);
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		registry.addViewController("/").setViewName("forward:index");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
		logger.info("index view loaded!");
	}
	 @Override
	    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	        super.addResourceHandlers(registry);
	    }
}