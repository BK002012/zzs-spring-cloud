package com.ljj.springcloud.config;

import com.ljj.springcloud.listener.GenerateHtmlMessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.Destination;

@Configuration
public class SubscribeConfig {

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

//    配置默认的消息监听器容器
    @Bean
    public DefaultMessageListenerContainer listenerContainer() {
        DefaultMessageListenerContainer m = new DefaultMessageListenerContainer();
        //注入连接工厂
        m.setConnectionFactory(connectionFactory());
        //注入目标对象
        Destination d = new ActiveMQQueue("*");//*表示通配所有队列名称
        m.setDestination(d);
        //注入自定义的消息监听器
        m.setMessageListener(new GenerateHtmlMessageListener());
        return m;
    }
}
