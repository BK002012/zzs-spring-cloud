package com.ljj.microservicehotelfreemarker.pojo;

import lombok.Data;

/**
 * @param
 * @Author: HEJIE
 * @Time: 9:28 2018/12/19
 * @version: v1.0
 */
@Data
public class TbHotel {
    private int id;
    private String hotel_id;
    private String hotel_name;
    private String hotel_location;
    private double hotel_score;
    private int hotel_rate;
    private String hotel_intime;
    private String hotel_outtime;
    private String hotel_buildtime;
    private String hotel_rebuildtime;
    private int hotel_rooms;
    private String main_facility;
    private String hotel_service;
    private String hotel_facility;
    private String room_facility;
    private String hotel_help;
    private String hotel_img;
    private String short_info;

}
