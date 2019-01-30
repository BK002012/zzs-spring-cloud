package com.ljj.springcloud.web;

import com.ljj.springcloud.dto.TravelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class TravelsAction {
    private  static  final String REST_URL_PREFIX = "http://localhost:8090";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/travelClient/list")
    public Page<TravelDTO> toHome(){

        return restTemplate.getForObject(REST_URL_PREFIX+"/travels/list", Page.class);
    }
}
