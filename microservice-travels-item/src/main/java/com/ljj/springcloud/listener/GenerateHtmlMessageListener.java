package com.ljj.springcloud.listener;

import com.ljj.springcloud.dao.TravelContentDao;
import com.ljj.springcloud.dto.TravelContent;
import com.ljj.springcloud.dto.TravelDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GenerateHtmlMessageListener implements MessageListener {
    private static final String REST_URL_PREFIX = "http://localhost:8090";

    @Autowired
    private TravelContentDao travelContentDao;

    @Autowired//每个自动注入的都应该有一个bean和它对应才能生效
    private FreeMarkerConfigurer freeMarkerConfigurer;

    public static GenerateHtmlMessageListener g;
    public GenerateHtmlMessageListener(){}
    @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
    public void init() {
        g = this;
        g.travelContentDao = this.travelContentDao;
        g.freeMarkerConfigurer=this.freeMarkerConfigurer;
        // 初使化时将已静态化的testService实例化
    }

    @Override
    public void onMessage(Message message) {

        try {
            //1、接收消息
            String id = "";
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;

                id = textMessage.getText();

            }
            System.out.println("l:"+id);
            //2、查询对象
            List<TravelContent> travelContents = g.travelContentDao.travelContent(id);
            //3、生成静态页面
            Configuration configuration = g.freeMarkerConfigurer.getConfiguration();
            //获取模板
            Template template = configuration.getTemplate("ftl/detail.ftl");
            //获取数据
            Map<String,Object> dataModel = new HashMap<>();
            dataModel.put("dtolist",travelContents);
            //输出到本地
            Writer out  = new FileWriter("E:/project/zzs-spring-cloud/microservice-travels-consumer/src/main/resources/templates/item/"+id+".html");
            template.process(dataModel,out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}