package com.example.dubboclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ImportResource("classpath:dubbo-consumer.xml")
public class DubboClientApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(DubboClientApplication.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DubboClientApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        logger.info("Web admin started!!!");
    }
}
