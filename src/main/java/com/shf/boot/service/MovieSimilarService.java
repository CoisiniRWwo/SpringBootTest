package com.shf.boot.service;

import com.shf.boot.bean.MovieSimilar;
import com.shf.boot.mapper.MovieSimilarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:Su HangFei
 * @Date:2023-01-04 14 51
 * @Project:boot-05-web-admin
 */

@Service
public class MovieSimilarService {

    @Autowired
    MovieSimilarMapper movieSimilarMapper;

    public MovieSimilar getByMid(int id){
        return movieSimilarMapper.getSimilar(id);
    }
}
