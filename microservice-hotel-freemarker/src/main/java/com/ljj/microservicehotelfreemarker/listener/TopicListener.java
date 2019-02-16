package com.ljj.microservicehotelfreemarker.listener;

/**
 * @param
 * @Author: HJ
 * @Time: 下午11:51 19-2-15
 * @version: v1.0
 */

import com.ljj.microservicehotelfreemarker.service.FreemarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: elvin
 */
@Component
public class TopicListener {
    @Autowired
    private FreemarkerService freemarkerService;

    @JmsListener(destination = "hotelDetailFreemarker", containerFactory = "jmsListenerContainerTopic")
    public void receive(String text){
        Boolean aBoolean = freemarkerService.generalPageByFtl(Integer.parseInt(text));
        if(aBoolean==true){
            System.out.println("消息发生成功，页面生成完成");
        }
        System.out.println("TopicListener: consumer-a 收到一条信息: " + text);
    }
}