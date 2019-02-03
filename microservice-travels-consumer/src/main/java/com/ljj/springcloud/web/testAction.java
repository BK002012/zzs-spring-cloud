package com.ljj.springcloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class testAction {
    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("hello","hhhhhhh");
        Map map = new HashMap<String, String>();
        map.put("travels", "haha");
        map.put("totalPage", 10);
        map.put("pageNum", 1);

        model.addAttribute("map", map);
        return "homepage";
    }
}
