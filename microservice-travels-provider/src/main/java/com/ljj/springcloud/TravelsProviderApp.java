package com.ljj.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan(value = "com.ljj.springcloud.dao")
public class TravelsProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(TravelsProviderApp.class, args);
    }
}
