package com.ljj.springcloud.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "travelContent")
public class TravelContent {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "travelNoteId")
    private String travelNoteId;
    @Column(name = "travelNoteContentNo")
    private Integer travelNoteContentNo;//第几条
    @Column(name = "travelNoteContentType")
    private Integer travelNoteContentType;//是文字还是url
    @Column(name = "travelNoteContentText")
    private String travelNoteContentText;
}
