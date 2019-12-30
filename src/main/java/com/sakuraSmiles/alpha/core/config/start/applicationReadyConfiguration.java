package com.sakuraSmiles.alpha.core.config.start;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class applicationReadyConfiguration implements ApplicationListener<ApplicationReadyEvent> {
	private final static Logger logger = Logger.getLogger(applicationReadyConfiguration.class);
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	logger.info(getClass().getSimpleName());
    	System.out.println("Application readied time is " + df.format(System.currentTimeMillis()));
    }

}