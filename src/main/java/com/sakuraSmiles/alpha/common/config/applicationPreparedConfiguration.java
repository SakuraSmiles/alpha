package com.sakuraSmiles.alpha.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

public class applicationPreparedConfiguration implements ApplicationListener<ApplicationPreparedEvent> {
	private final static Logger logger = LoggerFactory.getLogger(applicationPreparedConfiguration.class);
	@Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
    	logger.info(getClass().getSimpleName());
    }

}