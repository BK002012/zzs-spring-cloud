package com.ljj.springcloud.po;

/**
 * @param
 * @Author: HJ
 * @Time: 下午5:31 19-1-24
 * @version: v1.0
 */
public class HotelBanner {
    private int id;
    private String url;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
