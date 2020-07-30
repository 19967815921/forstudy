package com.example.mdbdouban.service;

import com.example.mdbdouban.dao.MovieInsertDAO;
import com.example.mdbdouban.pojo.MdbMovie;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieInsertService {

    @Resource
    private MovieInsertDAO dao;

    /**
     * 添加电影信息
     * @param list 电影相关信息集合
     * @return 添加是否成功
     */
    public boolean movieInsert(List<Object> list) {
        Boolean bool = false;
        MdbMovie mdbMovie = (MdbMovie)list.get(1);
        String[][] actors = (String[][]) list.get(2);
        String[] movieTagsRel = (String[])list.get(3);
        if(dao.movieInsert(mdbMovie)){
            if(dao.setActors(actors,mdbMovie)&&dao.setMovieTagsRel(movieTagsRel,mdbMovie)){
                bool = true;
            }
        }
        return bool;
    }
}
