package com.ljj.springcloud.web;

import com.ljj.springcloud.pojo.dto.PageDTO;
import com.ljj.springcloud.pojo.dto.TravelDTO;
import com.ljj.springcloud.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TravelAction {

    @Autowired
    private TravelService travelService;


    @ResponseBody
    @GetMapping("/travels/list")
    public List<TravelDTO> find(@RequestParam Integer pageIndex, @RequestParam Integer pageSize) {
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPageIndex(pageIndex);
        pageDTO.setPageSize(pageSize);

        return travelService.list(pageDTO);
    }
}
