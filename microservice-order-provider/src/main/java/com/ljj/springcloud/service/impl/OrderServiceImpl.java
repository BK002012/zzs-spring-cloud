package com.ljj.springcloud.service.impl;

import com.ljj.springcloud.dao.OrderDao;
import com.ljj.springcloud.pojo.po.Order;
import com.ljj.springcloud.pojo.vo.OrderVO;
import com.ljj.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;



@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public int countOrders(Order order) {
        try{
            return orderDao.countOrders(order);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Order> listOrders(OrderVO orderVO) {
        try {
            return orderDao.listOrders(orderVO);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> getOrderByUid(String uid) {
        try {
            return orderDao.getOrderByUid(uid);
        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public Order getOrderByOid(String orderId) {
        try {
            return orderDao.getOrderByOid(orderId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateOrderByOrder(Order order) {
        order.setTotal(order.getPrice()*order.getCounts());
        try{
            return orderDao.updateOrderByOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int addOrderByOrder(Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        order.setTotal(order.getPrice()*order.getCounts());
        try {
            return orderDao.addOrderByOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int removeOrderByOid(String oid) {

        try {
            return orderDao.removeOrderByOid(oid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
