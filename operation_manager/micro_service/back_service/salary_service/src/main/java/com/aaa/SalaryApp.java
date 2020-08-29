package com.aaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author : bruceli
 * @version :$
 * @date :Created in 2020/7/31 21:18
 * @description :
 * @modified :
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@MapperScan("com.aaa.dao")
public class SalaryApp {

    public static void main(String[] args) {
        SpringApplication.run(SalaryApp.class,args);
    }
}
