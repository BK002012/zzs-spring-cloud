package com.ljj.springcloud.web;


import com.ljj.springcloud.po.HotelBanner;
import com.ljj.springcloud.service.HotelBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @param
 * @Author: HJ
 * @Time: 下午9:43 19-1-24
 * @version: v1.0
 */
@Controller
public class HotelBannerImages {
    @Autowired
    private HotelBannerService service;
    @ResponseBody
    @GetMapping("getbannerimg")
    public List<HotelBanner> getAllBannerImages(){
        System.out.println("及覅额及覅额及覅额及覅");
        return service.listsHotelBanner();
    }

}
