package com.sakuraSmiles.alpha.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class applicationReadyConfiguration implements ApplicationListener<ApplicationReadyEvent> {
	private final static Logger logger = LoggerFactory.getLogger(applicationReadyConfiguration.class);
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
    	logger.info("......applicationReadyConfiguration......");
    }

}