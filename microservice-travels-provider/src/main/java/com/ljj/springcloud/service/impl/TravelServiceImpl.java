package com.ljj.springcloud.service.impl;

import com.ljj.springcloud.dao.TravelDao;
import com.ljj.springcloud.pojo.dto.TravelDTO;
import com.ljj.springcloud.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelDao travelDao;

    @Override
    public TravelDTO findOne(Integer id) {
        return travelDao.findOne(id);
    }

    @Override
    public Page<TravelDTO> find(Integer pageIndex, Integer pageSize) {
        if (null == pageIndex|| "".equals(pageIndex)) {
            pageIndex = 0;
        }
        if (pageSize == null || "".equals(pageSize)) {
            pageSize = 10;
        }
        PageRequest pageable = new PageRequest(pageIndex, pageSize);
        Page<TravelDTO> travels = travelDao.findAll(pageable);
        return travels;
    }
}
