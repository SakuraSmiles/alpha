package com.sakuraSmiles.alpha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sakuraSmiles.alpha.config.applicationFailedConfiguration;
import com.sakuraSmiles.alpha.config.applicationPreparedConfiguration;
import com.sakuraSmiles.alpha.config.applicationReadyConfiguration;
import com.sakuraSmiles.alpha.config.applicationStartedConfiguration;


@SpringBootApplication
public class alphaApplicaton {
	private final static Logger logger = LoggerFactory.getLogger(alphaApplicaton.class);
	public static void main(String[] args){
    	try{
    		SpringApplication application = new SpringApplication(alphaApplicaton.class);
    		application.addListeners(new applicationPreparedConfiguration());
    		application.addListeners(new applicationStartedConfiguration());
    		application.addListeners(new applicationReadyConfiguration());
    		application.addListeners(new applicationFailedConfiguration());
    		application.run(args);
    	}catch(Exception e){
    		logger.error("alpha-web-server starting error! ",e);
    	}
    }

}