package com.example.mdbdouban.service;

import com.example.mdbdouban.dao.MovieAddTagDAO;
import com.example.mdbdouban.pojo.MdbMovieTag;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MovieTagAddService {

    @Resource
    private MovieAddTagDAO dao;

    /**
     * 电影标签添加
     * @param mdbMovieTag 电影标签对象
     * @return 是否添加成功
     */
    public boolean movieAdd(MdbMovieTag mdbMovieTag) {
        return dao.movieAddTag(mdbMovieTag);
    }
}
