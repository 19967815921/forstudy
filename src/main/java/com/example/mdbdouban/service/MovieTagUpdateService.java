package com.example.mdbdouban.service;

import com.example.mdbdouban.dao.MovieTagUpdateDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Service
public class MovieTagUpdateService {

    @Resource
    private MovieTagUpdateDAO dao;

    /**
     * 电影标签更新
     * @param id 电影标签id
     * @param tagName 标签名称
     * @return 是否更新成功
     */
    public Boolean movieTagUpdate(Integer id, String tagName) {
        return dao.movieTagUpdate(id,tagName);
    }
}
