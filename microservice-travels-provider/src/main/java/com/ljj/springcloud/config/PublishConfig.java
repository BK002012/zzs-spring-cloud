package com.ljj.springcloud.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class PublishConfig {

    //配置目标对象
    @Bean
    public ActiveMQTopic topicDestination(){
        return new ActiveMQTopic("addBorrowTopic");
    }

    //配置connectionfactory
    @Bean
    public ActiveMQConnectionFactory targetConnectionFactory(){
        ActiveMQConnectionFactory a = new ActiveMQConnectionFactory();
        a.setBrokerURL("tcp://47.101.169.146:61616");
        return a;
    }

    @Bean
    public SingleConnectionFactory connectionFactory(){
        SingleConnectionFactory s = new SingleConnectionFactory();
        s.setTargetConnectionFactory(targetConnectionFactory());
        return s;
    }

//    配置发布者的jmstemplate
    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate j = new JmsTemplate();
        j.setConnectionFactory(connectionFactory());
        return j;
    }
}
