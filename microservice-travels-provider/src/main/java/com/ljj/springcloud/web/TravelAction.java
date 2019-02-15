package com.ljj.springcloud.web;

import com.ljj.springcloud.pojo.dto.PageDTO;
import com.ljj.springcloud.pojo.dto.TravelDTO;
import com.ljj.springcloud.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TravelAction {

    @Autowired
    private TravelService travelService;
    @Autowired
    private JmsTemplate jmsTemplate;
    //使用名称注入
    @Autowired
    @Qualifier("topicDestination")
    private Destination topicDestination;

    @ResponseBody
    @GetMapping("/travels/list")
    public Map<String,Object> find(@RequestParam Integer pageIndex, @RequestParam Integer pageSize,@RequestParam String search) {
        Map<String,Object> map = new HashMap<>();
        //
        System.out.println(search);

        PageDTO pageDTO = new PageDTO();
        pageDTO.setPageIndex(pageIndex);
        pageDTO.setPageSize(pageSize);
        pageDTO.setOffset((pageDTO.getPageIndex()-1)*pageDTO.getPageSize());
        List<TravelDTO> list = travelService.list(pageDTO,search);
        //各个游记内容
        map.put("travels",list);
        Long total = travelService.count(search);
        //共有多少个游记
        map.put("total",total);
        //共有多少页
        int totalPage = (int)Math.ceil(total*1.0 / pageSize);
        //当前页
        map.put("search",search);
        map.put("pageIndex",pageIndex);

        map.put("totalPage",totalPage);
        return map;
    }

    /**
     * 消息发送方，当收到从client中收到的请求时，发送消息到queue中，item微服务通过监听器收到消息
     * @param travelNoteId
     */
    @ResponseBody
    @GetMapping("/travel")
    public Map<String,Object> travelTest(@RequestParam("travelNoteId")String travelNoteId) {
        String id = travelNoteId;
        Map<String,Object> map = new HashMap<>();
        map.put("msg","failed");

        jmsTemplate.send(topicDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(id);
                return textMessage;
            }
        });
        map.put("msg","success");
        return map;
    }

    /**
     * 返回对象
     * @return
     */
    @ResponseBody
    @GetMapping("/travels/travel")
    public TravelDTO travel() {
        Integer id = 1;
        return travelService.travel(id);
    }
}
