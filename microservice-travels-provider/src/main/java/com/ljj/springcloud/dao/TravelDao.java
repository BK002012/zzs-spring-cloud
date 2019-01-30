package com.ljj.springcloud.dao;


import com.ljj.springcloud.pojo.dto.TravelDTO;
import com.ljj.springcloud.pojo.dto.PageDTO;

import java.util.List;

public interface TravelDao {
    List<TravelDTO> list(PageDTO pageDTO);
}
