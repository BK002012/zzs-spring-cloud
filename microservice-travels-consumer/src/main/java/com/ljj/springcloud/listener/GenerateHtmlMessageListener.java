package com.ljj.springcloud.listener;

import com.ljj.springcloud.dto.TravelDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Component
public class GenerateHtmlMessageListener implements MessageListener {
    private static final String REST_URL_PREFIX = "http://localhost:8090";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired//每个自动注入的都应该有一个bean和它对应才能生效
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public void onMessage(Message message) {

        try {
            //1、接收消息
            String id = "";
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;

                id = textMessage.getText();

            }
            //2、查询对象
            /**
             * listener中restTemplate取出的数据是空的，难道是因为reTemplate的数据已经在action中取出来了吗？
             */
//            TravelDTO travel = restTemplate.getForObject(REST_URL_PREFIX+"/travels/travel", TravelDTO.class);
            Map<String, Object> map = restTemplate.getForObject(REST_URL_PREFIX + "/travels/list?pageIndex=1&pageSize=10", Map.class);
            //3、生成静态页面
            Configuration configuration = freeMarkerConfigurer.getConfiguration();
            //获取模板
            Template template = configuration.getTemplate("ftl/1.ftl");
            //获取数据
            Map<String,Object> dataModel = new HashMap<>();
            dataModel.put("dto",map);
            //输出到本地
            Writer out  = new FileWriter("E:/project/zzs-spring-cloud/microservice-travels-consumer/src/main/resources/templates/"+id+".html");
            template.process(dataModel,out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
