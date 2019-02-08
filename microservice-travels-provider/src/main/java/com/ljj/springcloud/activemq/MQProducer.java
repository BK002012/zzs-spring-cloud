package com.ljj.springcloud.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.Date;

@Component
@EnableScheduling
public class MQProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    public void send() {
        System.out.println();
        System.out.println(new Date().toLocaleString());
        //send queue.
        this.jmsMessagingTemplate.convertAndSend(this.queue, "hi,activeMQ(queue)");
        //send topic.
        this.jmsMessagingTemplate.convertAndSend(this.topic, "hi,activeMQ(topic)");
    }
}
