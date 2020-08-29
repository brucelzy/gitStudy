package com.aaa.sls;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.aaa.sls.dao")
@EnableDiscoveryClient
public class SingleLogApp {
    public static void main(String[] args) {
        SpringApplication.run(SingleLogApp.class,args);
    }
}
