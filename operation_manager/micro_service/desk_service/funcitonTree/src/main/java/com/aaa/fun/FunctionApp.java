package com.aaa.fun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages = "com.aaa.fun.dao")
@EnableDiscoveryClient
public class FunctionApp {
    public static void main(String[] args) {
        SpringApplication.run(FunctionApp.class,args);
    }
}
