package com.ljj.springcloud.web;

import com.ljj.springcloud.pojo.dto.TravelDTO;
import com.ljj.springcloud.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TravelAction {

    @Autowired
    private TravelService travelService;

    @ResponseBody
    @GetMapping("/travels/get/{id}")
    public TravelDTO findOne(@PathVariable Integer id) {
        return travelService.findOne(id);
    }

    @ResponseBody
    @GetMapping("/travels/list")
    public Page<TravelDTO> find(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        return travelService.find(pageIndex, pageSize);
    }
}
