package com.ljj.springcloud.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MQConsumer {
    @JmsListener(destination = "sample.topic",containerFactory = "jmsListenerContainerTopic") // 监听指定消息主题
    public void receiveTopic(String message) {
        System.out.println("MQConsumer"+message);
    }

    @JmsListener(destination = "sample.queue",containerFactory = "jmsListenerContainerQueue") // 监听指定消息主题
    public void receiveQueue(String message) {
        System.out.println("MQConsumer"+message);
    }
}
