package com.sakuraSmiles.alpha.common.config;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
public class applicationStartedConfiguration implements ApplicationListener<ApplicationStartedEvent> {
	private final static Logger logger = LoggerFactory.getLogger(applicationStartedConfiguration.class);
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
    	logger.info(getClass().getSimpleName());
    	System.out.println("Application started!");
    }
}