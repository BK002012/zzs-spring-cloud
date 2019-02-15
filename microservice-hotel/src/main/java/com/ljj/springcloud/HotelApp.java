package com.ljj.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.ljj.springcloud.dao")
@EnableCaching
public class HotelApp {
    public static void main(String[] args) {
        SpringApplication.run(HotelApp.class, args);
    }
}
