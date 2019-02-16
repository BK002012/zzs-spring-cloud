package com.ljj.microservicehotelfreemarker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @param
 * @Author: HJ
 * @Time: 下午5:52 19-2-16
 * @version: v1.0
 */
@Controller
public class ShowPage {
    @GetMapping("show/{id}")
    public String showpage(@PathVariable("id")String id){
        System.out.println("id:"+id);
        return id;
    }
}
