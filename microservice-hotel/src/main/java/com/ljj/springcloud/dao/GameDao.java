package com.ljj.springcloud.dao;

import com.ljj.springcloud.dto.TestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @param
 * @Author: HJ
 * @Time: 上午12:37 19-1-24
 * @version: v1.0
 */
@Mapper
public interface GameDao {
    TestDTO findGameById(@Param("id") int id);
}
