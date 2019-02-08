package com.ljj.springcloud;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 *  这里主要涉及到几个角色，消息生产者，消息队列，消息消费者。所以只需要把这个解决实现了，编码也就完成了。
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan(value = "com.ljj.springcloud.dao")
public class TravelsProviderApp {

    @Bean//返回一个名为 my-message 的队列,并且注册为 bean
    public Queue queue(){
        return new ActiveMQQueue("sample.queue");
    }

    @Bean
    public Topic topic(){
        return new ActiveMQTopic("sample.topic");
    }

    public static void main(String[] args) {
        SpringApplication.run(TravelsProviderApp.class, args);
    }
}
