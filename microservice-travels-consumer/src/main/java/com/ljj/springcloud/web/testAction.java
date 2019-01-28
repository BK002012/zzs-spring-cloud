package com.ljj.springcloud.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testAction {
    @GetMapping("/test")
    public String test(){
        return "hello";
    }
}
