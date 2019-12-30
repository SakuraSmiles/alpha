package com.sakuraSmiles.alpha.core.config.start;

import org.apache.log4j.Logger;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;


public class applicationFailedConfiguration implements ApplicationListener<ApplicationFailedEvent> {
	private final static Logger logger = Logger.getLogger(applicationFailedConfiguration.class);
    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
    	logger.info(getClass().getSimpleName());
    	System.out.println("Application start failed!");
    }

}