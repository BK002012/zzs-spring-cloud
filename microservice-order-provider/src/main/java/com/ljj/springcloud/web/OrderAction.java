package com.ljj.springcloud.web;


import com.ljj.springcloud.pojo.po.Order;
import com.ljj.springcloud.pojo.vo.OrderVO;
import com.ljj.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderAction {
    @Autowired
    private OrderService orderService;

    @ResponseBody
    @GetMapping("/order")
    public OrderVO showAllOrder(Order order, @RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "5") Integer pageSize) {
        System.out.println(order);
        OrderVO orderVO = new OrderVO(pageIndex, pageSize, order);

        System.out.println(orderVO);
        int totalCount = orderService.countOrders(order);
        orderVO.setOrders(orderService.listOrders(orderVO));
        orderVO.setTotalCount(totalCount);
        return orderVO;
    }

    @ResponseBody
    @GetMapping("/order/{oid}")
    public Order getOrderByOid(@PathVariable String oid) {
        Order order = orderService.getOrderByOid(oid);
        return order;
    }

    @ResponseBody
    @PostMapping("/order")
    public int addOrderByOrder(@RequestBody Order order) {
        System.out.println(order);
        return orderService.addOrderByOrder(order);

    }

    @ResponseBody
    @PutMapping("/order")
    public int editOrderByOrder(@RequestBody Order order) {
        System.out.println(order);
        return orderService.updateOrderByOrder(order);

    }

    @ResponseBody
    @DeleteMapping("/order/{oid}")
    public int removeOrderByOid(@PathVariable String oid){

        System.out.println(oid);
        return orderService.removeOrderByOid(oid);
    }

    @GetMapping("/mfw_order")
    public String order(Model model){
        List<Order> orders = orderService.getOrderByUid("3");
        model.addAttribute("orders", orders);
        return "mfw_order";
    }

//    int updateOrderByOrder(Order order);
//
//    int addOrderByOrder(Order order);
//
//    int removeOrderByUid(String uid);

}
