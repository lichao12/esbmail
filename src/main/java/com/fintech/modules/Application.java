package com.fintech.modules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: springboot启动主入口
 * @author lc
 * @date 2018年6月26日
 */
@EnableEurekaClient
@SpringBootApplication
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("===============Spring Boot start=========================");
        SpringApplication.run(Application.class, args);
        logger.info("===============Spring Boot end=========================");
    }
}
