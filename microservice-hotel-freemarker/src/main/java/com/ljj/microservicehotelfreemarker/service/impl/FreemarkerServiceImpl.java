package com.ljj.microservicehotelfreemarker.service.impl;

import com.ljj.microservicehotelfreemarker.dao.*;
import com.ljj.microservicehotelfreemarker.pojo.TbHotel;
import com.ljj.microservicehotelfreemarker.service.FreemarkerService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileWriter;

/**
 * @param
 * @Author: HJ
 * @Time: 下午8:59 19-2-15
 * @version: v1.0
 */
@Service
public class FreemarkerServiceImpl implements FreemarkerService {
    @Autowired
    private TbHotelDao tbHotelDao;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    //    根据内容生成模板文件
    @Override
    public Boolean generalPageByFtl(int id) {
        TbHotel hotel = tbHotelDao.findHotelById(id);
        /* *生成模板文件
         * 1获得conguration
         * 2获取模板文件
         * 3获取数据
         * 4.生成静态页面
         *
         * */
        //写文件
        Writer out = null;
        try {
            //1/获得conguration
            Configuration configuration = freeMarkerConfigurer.getConfiguration();
            //2.获取模板文件
            Template template = ((freemarker.template.Configuration) configuration).getTemplate("ftl/hoteldetail.ftl");
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("hotel", hotel);
            dataModel.put("hotelFacilitys",hotel.getHotel_facility().split(","));
            dataModel.put("services",hotel.getHotel_service().split(","));
            dataModel.put("roomFacilitys",hotel.getRoom_facility().split(","));
            dataModel.put("mainfacilitys",hotel.getMain_facility().split(","));
            File file=new File("getabsolute.html");
            String path = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("/"));
            String path2 = path.substring(0, path.lastIndexOf("/"));
            out = new FileWriter(new File(path2+"/microservice-hotel-freemarker/src/main/resources/templates/ftl_html/"+id+".html"));
            //将测试的文件删除
            if(file.exists()){
                file.delete();
            }
            template.process(dataModel, out);
            //关闭流
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }

        if (hotel != null) {
            return true;
        }
        return false;
    }
}
