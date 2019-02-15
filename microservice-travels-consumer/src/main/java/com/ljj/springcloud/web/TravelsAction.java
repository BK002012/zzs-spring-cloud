package com.ljj.springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class TravelsAction {
    private static final String REST_URL_PREFIX = "http://localhost:8090";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String test(){
        return "redirect:/homepage/list";
    }

    @GetMapping("/homepage/list")//http://localhost:8090/travels/list?pageIndex=1&pageSize=10&search=沈阳
    public String list(Model model ,@RequestParam(defaultValue = "1") String pageIndex,@RequestParam(defaultValue = "") String search) {
        System.out.println(search);

        Map<String, Object> map= restTemplate.getForObject(REST_URL_PREFIX + "/travels/list?pageIndex="+Integer.parseInt(pageIndex)+"&pageSize=10&search="+search, Map.class);

        model.addAttribute("map", map);
        System.out.println(map);
        return "homepage";
    }

    @GetMapping("/item/menu")
    public String item(@RequestParam("travelNoteId") String travelNoteId){
        System.out.println(travelNoteId);
        restTemplate.getForObject(REST_URL_PREFIX+"/travel?travelNoteId="+travelNoteId,Map.class);
        return "redirect:/item/"+travelNoteId;
    }

    @GetMapping("/item/{travelNoteId}")
    public String item2(@PathVariable("travelNoteId") String travelNoteId){
        return "item/"+travelNoteId;
    }

}
