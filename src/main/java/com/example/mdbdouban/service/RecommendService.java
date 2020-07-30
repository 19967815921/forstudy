package com.example.mdbdouban.service;

import com.definesys.mpaas.query.db.PageQueryResult;
import com.example.mdbdouban.dao.RecommendDAO;
import com.example.mdbdouban.pojo.MdbComment;
import com.example.mdbdouban.pojo.MdbMovie;
import com.example.mdbdouban.pojo.MdbMovieTag;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendService {

    @Resource
    private RecommendDAO dao;

    /**
     * 根据页数和用户评分信息推荐电影
     * @param id 用户id
     * @param page 页面数
     * @return 推荐电影集合
     */
    public List<MdbMovie> recommend(Integer id,Integer page) {
        PageQueryResult<MdbMovie> list = null;
        List<MdbComment> comments;
        List<MdbMovieTag> mdbMovieTags;
        List<MdbMovie> movies = new ArrayList<MdbMovie>();
        comments = dao.searchHeightStar(id);
        if(comments.size() == 0){
            List<MdbMovie> movies1 = dao.searchMovie();
            for(int i = 5 * page; i < 5 * (page + 1);i++){
                movies.add(movies1.get(i));
            }
        }
        mdbMovieTags = dao.searchMovieTags(comments);
        list = dao.commentMovies(mdbMovieTags);
        for(int i = 5 * page; i < 5 * (page + 1);i++){
            movies.add(list.getResult().get(i));
        }
        return movies;
    }
}
