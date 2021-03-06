package com.ljj.microservicehotelfreemarker;

import com.ljj.microservicehotelfreemarker.dao.TbHotelDao;
import com.ljj.microservicehotelfreemarker.pojo.TbHotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @param
 * @Author: HJ
 * @Time: 上午1:04 19-2-16
 * @version: v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class mybatis {
    @Autowired
    private TbHotelDao tbHotelDao;
    @Test
    public void test(){
        System.out.println(tbHotelDao.findHotelById(5504508));
//        System.out.println(tbHotelDao.listTbHotel(0,100));
    }
    @Test
    public void test2(){
        List<String> hotelId = tbHotelDao.findHotelId();
        System.out.println(hotelId);
    }
}
