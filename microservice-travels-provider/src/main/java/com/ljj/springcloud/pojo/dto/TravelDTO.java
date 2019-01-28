package com.ljj.springcloud.pojo.dto;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "travelDTO")
public class TravelDTO {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "travelNoteId")
    private String travelNoteId;
    @Column(name = "travelNoteTitle")
    private String travelNoteTitle;
    @Column(name = "travelNoteBanner")
    private String travelNoteBanner;
    @Column(name = "travelNoteStyle")
    private String travelNoteStyle;
    @Column(name = "travelNotePrice")
    private double travelNotePrice;

}
