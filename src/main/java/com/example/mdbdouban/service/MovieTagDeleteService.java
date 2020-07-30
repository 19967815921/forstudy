package com.example.mdbdouban.service;

import com.example.mdbdouban.dao.MovieTagDeleteDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MovieTagDeleteService {

    @Resource
    private MovieTagDeleteDAO dao;

    /**
     * 电影标签删除
     * @param id 电影标签名
     * @return 是否删除成功
     */
    public boolean tagDelete(Integer id) {
        return dao.tagDelete(id);
    }
}
