package com.ljj.springcloud.web;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GenerateHtmlAction {
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @GetMapping("/generateHtml")
    public void generatehtml() throws IOException, TemplateException {
        //获取配置对象
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        //获取模板对象
        Template template = configuration.getTemplate("ftl/hhh.ftl");
//获取数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name","hhhh");
        //获取输出流
        Writer out = new FileWriter(new File("E:/project/zzs-spring-cloud/microservice-travels-provider/src/main/resources/templates/hhh.html"));
        //生成静态页面
        template.process(dataModel,out);
        //释放资源
        out.close();
    }
}
