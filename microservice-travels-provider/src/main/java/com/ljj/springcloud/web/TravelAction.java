package com.ljj.springcloud.web;

import com.ljj.springcloud.pojo.dto.PageDTO;
import com.ljj.springcloud.pojo.dto.TravelDTO;
import com.ljj.springcloud.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TravelAction {

    @Autowired
    private TravelService travelService;


    @ResponseBody
    @GetMapping("/travels/list")
    public Map<String,Object> find(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        Map<String,Object> map = new HashMap<>();

        PageDTO pageDTO = new PageDTO();
        pageDTO.setPageIndex(pageIndex);
        pageDTO.setPageSize(pageSize);
        List<TravelDTO> list = travelService.list(pageDTO);
        map.put("travels",list);
        Long total = travelService.count();
        map.put("total",total);
        //共有多少页
        int totalPage = (int)Math.ceil(total / pageSize);
        map.put("totalPage",totalPage);
        return map;
    }
}
