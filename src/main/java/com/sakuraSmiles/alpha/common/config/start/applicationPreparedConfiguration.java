package com.sakuraSmiles.alpha.common.config.start;


import org.apache.log4j.Logger;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

public class applicationPreparedConfiguration implements ApplicationListener<ApplicationPreparedEvent> {
	private final static Logger logger = Logger.getLogger(applicationPreparedConfiguration.class);
	@Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
    	logger.info(getClass().getSimpleName());
    }

}