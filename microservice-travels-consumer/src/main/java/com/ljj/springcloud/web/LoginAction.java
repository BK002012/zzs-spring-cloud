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

    @PostMapping("/login")
    public String login(@RequestParam("passport") String passport,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(passport) && "123456".equals(password)) {
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser", passport);
            return "redirect:/homepage/list";
        } else {
            //登陆失败
            map.put("msg", "用户名密码错误");
            return "login";
        }

    }

    @ResponseBody
    @GetMapping("/getTravelById/{id}")
    public TravelDTO getTravelById(@PathVariable Integer id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/travels/" + id, TravelDTO.class);
    }
}
