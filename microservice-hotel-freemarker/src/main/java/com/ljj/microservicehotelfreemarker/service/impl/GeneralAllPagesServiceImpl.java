package com.ljj.microservicehotelfreemarker.service.impl;

import com.ljj.microservicehotelfreemarker.dao.TbHotelDao;
import com.ljj.microservicehotelfreemarker.service.FreemarkerService;
import com.ljj.microservicehotelfreemarker.service.GeneralAllPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @param
 * @Author: HJ
 * @Time: 上午12:28 19-2-17
 * @version: v1.0
 */
@Service
public class GeneralAllPagesServiceImpl implements GeneralAllPageService {
    @Autowired
    public TbHotelDao tbHotelDao;
    @Autowired
    private FreemarkerService freemarkerService;
    @Override
    public int GeneralPages() {
        List<String> hotelId = tbHotelDao.findHotelId();
        for (String id:hotelId) {
            Boolean aBoolean = freemarkerService.generalPageByFtl(Integer.parseInt(id));
        }
        return hotelId.size();
    }
}
