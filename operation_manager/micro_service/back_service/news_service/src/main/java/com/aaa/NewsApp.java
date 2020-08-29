package com.aaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : bruceli
 * @version :$
 * @date :Created in 2020/8/1 11:10
 * @description :
 * @modified :
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.aaa.dao")
public class NewsApp {
    public static void main(String[] args) {
        SpringApplication.run(NewsApp.class,args);
    }
}
