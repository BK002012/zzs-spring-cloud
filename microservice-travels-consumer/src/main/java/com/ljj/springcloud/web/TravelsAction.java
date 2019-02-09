package com.ljj.springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class TravelsAction {
    private static final String REST_URL_PREFIX = "http://localhost:8090";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/homepage/list")
    public String list(Model model) {
        Map<String, Object> map = restTemplate.getForObject(REST_URL_PREFIX + "/travels/list?pageIndex=1&pageSize=10", Map.class);
        model.addAttribute("map", map);
        System.out.println(map);
        return "homepage";
    }

}
