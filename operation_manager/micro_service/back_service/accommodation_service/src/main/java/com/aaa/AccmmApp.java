package com.aaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：奎
 * @date ：Created in 2020/8/3 11:00
 * @description：启动类
 * @modified By：
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan("com.aaa.dao")
@EnableDiscoveryClient
public class AccmmApp {
    public static void main(String[] args) {
        SpringApplication.run(AccmmApp.class,args);
    }
}
