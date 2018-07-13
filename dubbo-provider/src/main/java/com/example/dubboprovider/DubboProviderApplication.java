package com.example.dubboprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableScheduling
@ServletComponentScan
@SpringBootApplication
@EnableTransactionManagement
@ImportResource("classpath:dubbo-provider.xml")
public class DubboProviderApplication {

    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(DubboProviderApplication.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DubboProviderApplication.class);
        application.setRegisterShutdownHook(false);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        logger.info("Service provider started!!!");
    }
}
