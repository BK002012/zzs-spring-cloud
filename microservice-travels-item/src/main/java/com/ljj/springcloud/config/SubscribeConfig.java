package com.ljj.springcloud.config;

import com.ljj.springcloud.listener.GenerateHtmlMessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

@Configuration
public class SubscribeConfig {
    //配置目标对象
    @Bean
    public ActiveMQTopic topicDestination(){
        return new ActiveMQTopic("addBorrowTopic");
    }

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
        m.setDestination(topicDestination());
        //注入自定义的消息监听器
        m.setMessageListener(new GenerateHtmlMessageListener());
        return m;
    }
}
