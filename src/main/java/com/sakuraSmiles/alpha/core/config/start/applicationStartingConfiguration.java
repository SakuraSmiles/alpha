package com.sakuraSmiles.alpha.core.config.start;

import org.apache.log4j.Logger;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class applicationStartingConfiguration implements ApplicationListener<ApplicationStartedEvent> {
	private final static Logger logger = Logger.getLogger(applicationStartingConfiguration.class);
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
    	logger.info(getClass().getSimpleName());
    	System.out.println("Application starting...");
    }

}