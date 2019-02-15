package com.ljj.springcloud.service.impl;

import com.ljj.springcloud.dao.TravelDao;
import com.ljj.springcloud.pojo.dto.PageDTO;
import com.ljj.springcloud.pojo.dto.TravelDTO;
import com.ljj.springcloud.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelDao travelDao;

    @Override
    public List<TravelDTO> list(PageDTO pageDTO,String search) {
        List<TravelDTO> list = travelDao.list(pageDTO.getOffset(),pageDTO.getPageSize(),search);
        return list;
    }

    @Override
    public Long count(String search) {
        return travelDao.count(search);
    }

    @Override
    public TravelDTO travel(Integer id) {
        return travelDao.travel(id);
    }
}
