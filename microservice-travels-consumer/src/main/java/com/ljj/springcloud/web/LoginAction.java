package com.ljj.springcloud.web;

import com.ljj.springcloud.dto.TravelDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginAction {
    private static final String REST_URL_PREFIX = "http://localhost:8090";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index(){
        return "homepage";
    }

    @PostMapping("/userlogin")
    public String login() {
        return "login";
    }

    @ResponseBody
    @GetMapping("/getTravelById/{id}")
    public TravelDTO getTravelById(@PathVariable Integer id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/travels/" + id, TravelDTO.class);
    }
}
