package com.ljj.springcloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestAction {

    @GetMapping("/test")
    public String test(){
        return "ftl/1";
    }
}
