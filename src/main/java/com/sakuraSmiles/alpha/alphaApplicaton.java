package com.sakuraSmiles.alpha;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sakuraSmiles.alpha.core.config.start.applicationEnvironmentPreparedConfiguration;
import com.sakuraSmiles.alpha.core.config.start.applicationFailedConfiguration;
import com.sakuraSmiles.alpha.core.config.start.applicationPreparedConfiguration;
import com.sakuraSmiles.alpha.core.config.start.applicationReadyConfiguration;
import com.sakuraSmiles.alpha.core.config.start.applicationStartedConfiguration;
import com.sakuraSmiles.alpha.core.config.start.applicationStartingConfiguration;


@SpringBootApplication
public class alphaApplicaton {
    private final static Logger logger = Logger.getLogger(alphaApplicaton.class);

    public static void main(String[] args) {
        try {
            SpringApplication application = initApplication();
            application.run(args);
        } catch (Exception e) {
            logger.error("alpha-web-server starting error! ", e);
        }
    }

    /**
     * 初始化application,添加监听器
     *
     * @return
     * @author:wangchb
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