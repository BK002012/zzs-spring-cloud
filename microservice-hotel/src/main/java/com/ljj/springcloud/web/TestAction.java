package com.ljj.springcloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @param
 * @Author: HJ
 * @Time: 下午11:55 19-2-14
 * @version: v1.0
 */
@Controller
public class TestAction {
    @GetMapping("/")
    private String Tetet(){
        return "index";
    }
}
