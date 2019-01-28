package com.ljj.springcloud.service;

import com.ljj.springcloud.pojo.dto.TravelDTO;

import java.util.List;

public interface TravelService {
    TravelDTO findOne(Integer id);
}
