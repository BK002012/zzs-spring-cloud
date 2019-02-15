package com.ljj.springcloud.dao;


import com.ljj.springcloud.pojo.dto.TravelDTO;
import com.ljj.springcloud.pojo.dto.PageDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TravelDao {
    List<TravelDTO> list(@Param(value = "offset")int offset,@Param(value = "pageSize")int pageSize, @Param(value = "search") String search);

    Long count(@Param(value = "search") String search);

    TravelDTO travel(Integer id);
}
