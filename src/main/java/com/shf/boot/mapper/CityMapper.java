package com.shf.boot.mapper;

import com.shf.boot.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {
    @Select("select * from city where id = #{id}")
    public City getById(Long id);

    //    @Insert("insert into user(`name`) values(#{name})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(City city);
}
