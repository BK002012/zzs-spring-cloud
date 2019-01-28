package com.ljj.springcloud.web;

import com.ljj.springcloud.dto.TravelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TravelsAction {
    private  static  final String REST_URL_PREFIX = "http://localhost:8090";

    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @GetMapping("/getTravelById/{id}")
    public TravelDTO getTravelById(@PathVariable Integer id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/travels/"+id,TravelDTO.class);
    }
}
