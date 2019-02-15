package com.ljj.microservicehotelfreemarker.dao;

import com.ljj.microservicehotelfreemarker.pojo.TbHotelFacility;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @param
 * @Author: HEJIE
 * @Time: 17:35 2018/12/22
 * @version: v1.0
 */
@Mapper
public interface HotelFacilityDao {
    List<TbHotelFacility> listHotelFacility();

}
