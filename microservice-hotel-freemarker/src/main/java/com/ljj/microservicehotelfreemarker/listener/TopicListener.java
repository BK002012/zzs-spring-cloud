package com.ljj.microservicehotelfreemarker.listener;

/**
 * @param
 * @Author: HJ
 * @Time: 下午11:51 19-2-15
 * @version: v1.0
 */

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: elvin
 */
@Component
public class TopicListener {

    @JmsListener(destination = "hotelDetailFreemarker", containerFactory = "jmsListenerContainerTopic")
    public void receive(String text){
        System.out.println("TopicListener: consumer-a 收到一条信息: " + text);
    }
}