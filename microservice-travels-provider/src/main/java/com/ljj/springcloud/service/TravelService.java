package com.ljj.springcloud.service;

import com.ljj.springcloud.pojo.dto.TravelDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TravelService {
    TravelDTO findOne(Integer id);

    Page<TravelDTO> find(Integer pageIndex, Integer pageSize);
}
