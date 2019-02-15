package com.ljj.springcloud.dao;

import com.ljj.springcloud.dto.TravelContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TravelContentDao {
    List<TravelContent> travelContent(@Param(value = "travelNoteId") String travelNoteId);
}
