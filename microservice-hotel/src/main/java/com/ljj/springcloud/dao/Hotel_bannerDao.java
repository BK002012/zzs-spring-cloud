package com.ljj.springcloud.dao;

import com.ljj.springcloud.po.HotelBanner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @param
 * @Author: HJ
 * @Time: 下午5:30 19-1-24
 * @version: v1.0
 */
@Mapper
public interface Hotel_bannerDao {
    List<HotelBanner> findImageUrl(@Param("offset") int offset, @Param("pagesize") int pagesize);
    int saveHotelBannerImageUrl(HotelBanner hb);
}
