package com.ljj.springcloud.web;

import com.ljj.springcloud.pojo.dto.TravelDTO;
import com.ljj.springcloud.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TravelAction {

    @Autowired
    private TravelService travelService;

    @ResponseBody
    @GetMapping("/travels/{id}")
    public TravelDTO findOne(@PathVariable Integer id){
        return travelService.findOne(id);
    }
}
