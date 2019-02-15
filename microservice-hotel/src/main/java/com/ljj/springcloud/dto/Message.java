package com.ljj.springcloud.dto;

import java.util.List;

/**
 * @param
 * @Author: HJ
 * @Time: 下午10:02 19-1-16
 * @version: v1.0
 */
public class Message {
    private String success;
    private Object message;
    private String json;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
