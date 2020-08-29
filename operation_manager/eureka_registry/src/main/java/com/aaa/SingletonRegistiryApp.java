package com.aaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ：奎
 * @date ：Created in 2020/7/21 15:50
 * @description：
 * @modified By：
 * @version:
 */
@SpringBootApplication
@EnableEurekaServer  //开启eureka注册中心服务端的功能
public class SingletonRegistiryApp {
    public static void main(String[] args) {
        SpringApplication.run(SingletonRegistiryApp.class,args);
    }
}
