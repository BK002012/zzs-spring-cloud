package com.ljj.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelsItemApp {

    public static void main(String[] args) {
        SpringApplication.run(TravelsItemApp.class, args);
    }
}
