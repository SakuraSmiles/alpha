package com.sakuraSmiles.alpha.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;


public class applicationFailedConfiguration implements ApplicationListener<ApplicationFailedEvent> {
	private final static Logger logger = LoggerFactory.getLogger(applicationFailedConfiguration.class);
    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
    	logger.info("......applicationFailedConfiguration......");
    }

}