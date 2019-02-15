package com.ljj.microservicehotelfreemarker.web;

/**
 * @param
 * @Author: HJ
 * @Time: 下午11:49 19-2-15
 * @version: v1.0
 */

import com.ljj.microservicehotelfreemarker.service.FreemarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author: elvin
 */
@RestController
@RequestMapping("/publish")
public class PublishController {

    @Autowired
    private JmsMessagingTemplate jms;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Autowired
    private FreemarkerService freemarkerService;

    @RequestMapping("/queue")
    public String queue(){

        for (int i = 0; i < 10 ; i++){
            jms.convertAndSend(queue, "queue"+i);
        }

        return "queue 发送成功";
    }

    @JmsListener(destination = "out.queue")
    public void consumerMsg(String msg){
        System.out.println(msg);
    }

    @RequestMapping("/topic")
    public String topic(){

        for (int i = 0; i < 10 ; i++){
            jms.convertAndSend(topic, "topic"+i);
        }

        return "topic 发送成功";
    }
    @RequestMapping("/hoteldetail/{id}")
    public String sendMessageFreemarker(@PathVariable("id")int id){
        Boolean generalPageByFtl = freemarkerService.generalPageByFtl(id);
        if (generalPageByFtl==true){
            return "message:"+id;
        }
        return "message:error";
    }
}