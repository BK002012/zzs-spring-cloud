package com.ljj.springcloud.service;

import com.ljj.springcloud.pojo.dto.PageDTO;
import com.ljj.springcloud.pojo.dto.TravelDTO;

import java.util.List;

public interface TravelService {
    List<TravelDTO> list(PageDTO pageDTO);
}
