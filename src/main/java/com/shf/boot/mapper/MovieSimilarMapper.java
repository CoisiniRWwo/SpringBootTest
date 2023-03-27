package com.shf.boot.mapper;

import com.shf.boot.bean.MovieSimilar;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieSimilarMapper {
    public MovieSimilar getSimilar(int id);
}
