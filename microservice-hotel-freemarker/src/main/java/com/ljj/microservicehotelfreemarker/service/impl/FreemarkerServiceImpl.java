package com.ljj.microservicehotelfreemarker.service.impl;

import com.ljj.microservicehotelfreemarker.dao.*;
import com.ljj.microservicehotelfreemarker.service.FreemarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @param
 * @Author: HJ
 * @Time: 下午8:59 19-2-15
 * @version: v1.0
 */
@Service
public class FreemarkerServiceImpl implements FreemarkerService {

    @Autowired
    private TbHotelDao tbHotelDao;
    @Autowired
    private HotelFacilityDao hotelFacilityDao;
    @Autowired
    private MainFacility mainFacility;
    @Autowired
    private RoomFacilityDao roomFacilityDao;
    @Autowired
    private HotelServiceDao hotelServiceDao;
    @Override
    public Boolean generalPageByFtl(int id) {
        return  false;
    }
}
