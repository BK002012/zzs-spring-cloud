package com.ljj.microservicehotelfreemarker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ljj.microservicehotelfreemarker.dao")
public class MicroserviceHotelFreemarkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceHotelFreemarkerApplication.class, args);
    }

}

