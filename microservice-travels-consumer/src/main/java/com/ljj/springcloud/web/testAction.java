package com.ljj.springcloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testAction {
    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("hello","hhhhhhh");
        return "homepage";
    }
}
