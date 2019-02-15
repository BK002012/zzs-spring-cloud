package com.ljj.springcloud.service.impl;


import com.ljj.springcloud.commons.util.JsonUtils;
import com.ljj.springcloud.commons.util.StrKit;
import com.ljj.springcloud.dao.Hotel_bannerDao;
import com.ljj.springcloud.po.HotelBanner;
import com.ljj.springcloud.service.HotelBannerService;
import com.ljj.springcloud.service.JedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.List;

/**
 * @param
 * @Author: HJ
 * @Time: 下午6:14 19-1-24
 * @version: v1.0
 */

@Service
public class HotelBannerServiceimpl implements HotelBannerService {
    @Autowired
    private Hotel_bannerDao dao;
    @Autowired
//    private JedisClient jedisClient;
    private JedisCluster jedisClient;
    private Logger logger = LoggerFactory.getLogger(HotelBannerServiceimpl.class);
    @Override
    public List<HotelBanner> listsHotelBanner() {

       /*
        1缓存中查询
        从缓存中获取数据
        2若缓存中不为空直接返回list
            若缓存中不存在则在mysql中查询
         3并将查询出的数据存放到缓存中
         */
        try{
            //1缓存中查询
            String bannerImageUrl_list = jedisClient.hget("bannerImageUrl","bannerImage");
            //判断查询出来的数据是否为空
            if(StrKit.notBlank(bannerImageUrl_list)){
                //如果为true不为空
//                直接返回list后面放的是泛型的类型
//                jedisClient.hdel("bannerImageUrl","bannerImage");
                return JsonUtils.jsonToList(bannerImageUrl_list, HotelBanner.class);
            }

        }catch (RuntimeException e){
            logger.debug(e.getMessage(),e);
        }
        //2. MySQL中查询
        //本方法主要内容，查询缓存不能影响到这个主业务
        List<HotelBanner> imageUrl =dao.findImageUrl(0,3);
        try {
            //将查询出来的list存放到缓存中
            jedisClient.hset("bannerImageUrl","bannerImage", JsonUtils.objectToJson(imageUrl));
        }catch (RuntimeException e){
            logger.debug(e.getMessage(),e);
        }
        return imageUrl;
    }

    @Override
    public int saveHotelBannerImageUrl(HotelBanner hb) {

        return dao.saveHotelBannerImageUrl(hb);
    }

}
