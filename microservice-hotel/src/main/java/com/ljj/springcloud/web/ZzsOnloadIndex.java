package com.ljj.springcloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @param
 * @Author: HJ
 * @Time: 下午4:48 19-1-24
 * @version: v1.0
 */
@Controller
public class ZzsOnloadIndex {
    @GetMapping("index")
    public String onLoadIndexJsp(Model model){
        //查询数据库中的
        //将查询的数据放到页面中

        return null;
    }
}
