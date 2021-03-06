package com.ljj.springcloud;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;
import javax.jms.Topic;

@SpringBootApplication
public class TravelsConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(TravelsConsumerApp.class, args);
    }
}
