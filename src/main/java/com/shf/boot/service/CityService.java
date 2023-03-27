package com.shf.boot.service;

import com.shf.boot.bean.City;
import com.shf.boot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:Su HangFei
 * @Date:2023-01-04 15 24
 * @Project:boot-05-web-admin
 */
@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;

    public City getById(Long id){
        return cityMapper.getById(id);
    }

    public void saveCity(City city) {
        cityMapper.insert(city);
    }
}
