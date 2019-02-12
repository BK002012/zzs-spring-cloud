package com.ljj.springcloud.dao;


import com.ljj.springcloud.dto.TravelDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TravelDao {

    TravelDTO travel(Integer id);
}
