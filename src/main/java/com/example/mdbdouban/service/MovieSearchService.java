package com.example.mdbdouban.service;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.dao.MovieSearchDAO;
import com.example.mdbdouban.pojo.MdbMovie;
import com.example.mdbdouban.pojo.MdbMovieTagRel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieSearchService {

    @Resource
    private MovieSearchDAO dao;

    /**
     * 电影信息查询
     * @param list 查询相关条件（电影名，标签列表）
     * @return
     */
    public List<MdbMovie> movieSearch(List<String> list) {
        List<MdbMovie> movies = null;
        List<MdbMovieTagRel> mdbMovieTagRels = null;
        if((mdbMovieTagRels = dao.searchMdbMovieTagRels(list.get(1))) == null){
            throw new MpaasBusinessException("没有相关的影视信息！");
        }
        for(int i = 2;i <= list.size();i++){
            for(int j = 1;j <= mdbMovieTagRels.size();j++){
                if(mdbMovieTagRels.get(j).getTagId().equals(list.get(i))){
                    MdbMovie movie = dao.searchMovies(mdbMovieTagRels.get(j).getMovieId());
                    movies.add(movie);
                }
            }
        }
        return movies;
    }
}
