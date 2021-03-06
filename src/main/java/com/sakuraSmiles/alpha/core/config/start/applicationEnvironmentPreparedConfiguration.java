package com.sakuraSmiles.alpha.core.config.start;


import org.apache.log4j.Logger;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

public class applicationEnvironmentPreparedConfiguration implements ApplicationListener<ApplicationPreparedEvent> {
	private final static Logger logger = Logger.getLogger(applicationEnvironmentPreparedConfiguration.class);
	@Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
    	logger.info(getClass().getSimpleName());
    	System.out.println("Application environment prepared!");
    }

}