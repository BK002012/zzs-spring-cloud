package com.ljj.springcloud.dto;

/**
 * @param
 * @Author: HJ
 * @Time: 下午8:16 19-1-16
 * @version: v1.0
 */
public class TestDTO {
    private String id;
    private String time;
    private String name;
    private String category;
    private String many;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMany() {
        return many;
    }

    public void setMany(String many) {
        this.many = many;
    }
}
