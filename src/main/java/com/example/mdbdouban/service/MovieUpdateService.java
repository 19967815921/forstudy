package com.example.mdbdouban.service;

import com.example.mdbdouban.dao.MovieUpdateDAO;
import com.example.mdbdouban.pojo.MdbMovie;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MovieUpdateService {

    @Resource
    private MovieUpdateDAO dao;

    /**
     * 电影信息更新
     * @param mdbMovie 电影对象
     * @return 是否更新成功
     */
    public boolean movieUpdate(MdbMovie mdbMovie) {
        return dao.movieUpdate(mdbMovie);
    }
}
