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

    @Bean//返回一个名为 my-message 的队列,并且注册为 bean
    public Queue queue(){
        return new ActiveMQQueue("sample.queue");
    }

    @Bean
    public Topic topic(){
        return new ActiveMQTopic("sample.topic");
    }

    public static void main(String[] args) {
        SpringApplication.run(TravelsConsumerApp.class, args);
    }
}
