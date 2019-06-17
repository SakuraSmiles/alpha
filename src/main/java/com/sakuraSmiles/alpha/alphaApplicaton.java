package com.sakuraSmiles.alpha;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sakuraSmiles.alpha.common.config.applicationEnvironmentPreparedConfiguration;
import com.sakuraSmiles.alpha.common.config.applicationFailedConfiguration;
import com.sakuraSmiles.alpha.common.config.applicationPreparedConfiguration;
import com.sakuraSmiles.alpha.common.config.applicationReadyConfiguration;
import com.sakuraSmiles.alpha.common.config.applicationStartedConfiguration;
import com.sakuraSmiles.alpha.common.config.applicationStartingConfiguration;
import com.sakuraSmiles.alpha.common.dao.IBaseDAO;


@SpringBootApplication
public class alphaApplicaton {
	private final static Logger logger = LoggerFactory.getLogger(alphaApplicaton.class);

	public static void main(String[] args){
    	try{
    		SpringApplication application = initApplication();
    		application.run(args);
    	}catch(Exception e){
    		logger.error("alpha-web-server starting error! ",e);
    	}
    }
	/**
	 * 初始化application,添加监听器
	 * @author:wangchb
	 * @return
	 * @time:2018年11月20日 上午10:41:14
	 */
	private static SpringApplication initApplication() {
		SpringApplication application = new SpringApplication(alphaApplicaton.class);
		application.addListeners(new applicationEnvironmentPreparedConfiguration());
		application.addListeners(new applicationPreparedConfiguration());
		application.addListeners(new applicationStartingConfiguration());
		application.addListeners(new applicationStartedConfiguration());
		application.addListeners(new applicationReadyConfiguration());
		application.addListeners(new applicationFailedConfiguration());
		return application;
	}
	

}