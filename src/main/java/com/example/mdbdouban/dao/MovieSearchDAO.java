package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbMovie;
import com.example.mdbdouban.pojo.MdbMovieTagRel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieSearchDAO {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 查找指定电影的标签电影相关信息
     * @param s 电影名
     * @return 标签电影相关信息集合
     */
    public List<MdbMovieTagRel> searchMdbMovieTagRels(String s) {
        List<MdbMovie> movies;
        List<MdbMovieTagRel> list = new ArrayList<MdbMovieTagRel>();
        try {
            movies = sw.buildQuery()
                    .like("name",s)
                    .doQuery(MdbMovie.class);
            for(MdbMovie movie : movies){
                List<MdbMovieTagRel> list1 = sw.buildQuery()
                        .eq("movie_id",movie.getId())
                        .doQuery(MdbMovieTagRel.class);
                list.add(list1.get(1));
            }
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return list;
        }
    }

    /**
     * 根据电影id查询电影
     * @param movieId 电影id
     * @return 电影信息对象
     */
    public MdbMovie searchMovies(Integer movieId) {
        List<MdbMovie> movie = null;
        try {
            movie = sw.buildQuery()
                    .eq("id",movieId)
                    .doQuery(MdbMovie.class);
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return movie.get(1);
        }
    }
}
