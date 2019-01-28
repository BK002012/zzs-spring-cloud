package com.ljj.springcloud.dao;

import com.ljj.springcloud.pojo.dto.TravelDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelDao extends JpaRepository<TravelDTO,Integer> {
}
