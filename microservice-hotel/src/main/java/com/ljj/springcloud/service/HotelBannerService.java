package com.ljj.springcloud.service;


import com.ljj.springcloud.po.HotelBanner;

import java.util.List;

/**
 * @param
 * @Author: HJ
 * @Time: 下午6:06 19-1-24
 * @version: v1.0
 */
public interface HotelBannerService {
    List<HotelBanner> listsHotelBanner();
    int saveHotelBannerImageUrl(HotelBanner hb);
}
