package com.ljj.springcloud.service.impl;

import com.ljj.springcloud.dao.TravelDao;
import com.ljj.springcloud.pojo.dto.TravelDTO;
import com.ljj.springcloud.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelDao travelDao;

    @Override
    public TravelDTO findOne(Integer id) {
        return travelDao.findOne(id);
    }
}
