package com.ljj.springcloud.pojo.vo;


import com.ljj.springcloud.pojo.po.Order;

import java.util.List;

public class OrderVO {
    private int pageIndex;
    private int pageSize;
    private int offset;
    private int totalCount;
    private Order order;
    private List<Order> orders;
    private int totalPage;

    public OrderVO() {
    }

    public OrderVO(int pageIndex, int pageSize, Order order) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                ", totalCount=" + totalCount +
                ", order=" + order +
                ", orders=" + orders +
                ", totalPage=" + totalPage +
                '}';
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }



    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return (pageIndex - 1)*pageSize;
    }

    public int getTotalPage(){
        return (this.totalCount+this.pageSize-1)/this.pageSize;
    }

}
