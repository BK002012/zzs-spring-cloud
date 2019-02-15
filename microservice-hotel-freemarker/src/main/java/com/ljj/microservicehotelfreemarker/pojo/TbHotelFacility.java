package com.ljj.microservicehotelfreemarker.pojo;

/**
 * @param
 * @Author: HEJIE
 * @Time: 17:37 2018/12/22
 * @version: v1.0
 */
public class TbHotelFacility {
    private int id;
    private int cid;
    private String cname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
