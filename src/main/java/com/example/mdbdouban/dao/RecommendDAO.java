package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.definesys.mpaas.query.db.PageQueryResult;
import com.example.mdbdouban.pojo.MdbComment;
import com.example.mdbdouban.pojo.MdbMovie;
import com.example.mdbdouban.pojo.MdbMovieTag;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class RecommendDAO {

    @Resource
    private MpaasQueryFactory sw;


    /**
     * 查找该用户的高分评论信息
     * @param id 用户id
     * @return
     */
    public List<MdbComment> searchHeightStar(Integer id) {
        List<MdbComment> list = null;
        try{
            list = sw.buildQuery()
                    .eq("userId",id)
                    .gteq("star",4)
                    .orderBy("star","desc")
                    .doQuery(MdbComment.class);
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return list;
        }
    }

    /**
     * 查找电影标签信息
     * @param comments 评论集合
     * @return 电影标签集合
     */
    public List<MdbMovieTag> searchMovieTags(List<MdbComment> comments) {
        List<MdbMovieTag> list = null;
        try{
            for(MdbComment mdbComment : comments){
                List<MdbMovieTag> mdbMovieTags = sw.buildQuery()
                        .eq("movieId",mdbComment.getMovieId())
                        .doQuery(MdbMovieTag.class);
                if(list != null){
                    boolean bool = false;
                    for(int i = 0;i < list.size();i++){
                        if(mdbMovieTags.get(1).getId() == list.get(i+1).getId()){
                            bool = true;
                            break;
                        }
                    }
                    if(bool == false){
                        list.add(mdbMovieTags.get(1));
                    }
                }else{
                    list.add(mdbMovieTags.get(1));
                }
            }
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return list;
        }
    }

    /**
     * 查找用户喜好的相关电影
     * @param mdbMovieTags 电影标签集合
     * @return 用户喜好电影集合
     */
    public PageQueryResult<MdbMovie> commentMovies(List<MdbMovieTag> mdbMovieTags) {
        PageQueryResult<MdbMovie> result = null;
        try{
            for(MdbMovieTag mdbMovieTag : mdbMovieTags){
                List<MdbMovie> movies = sw.buildQuery()
                        .eq("movieId",mdbMovieTag.getId())
                        .doQuery(MdbMovie.class);
                if(result == null){
                    result.setCount(Long.valueOf(movies.size()));
                    result.setResult(movies);
                }else{
                    result.setCount(result.getCount() + movies.size());
                    List<MdbMovie> movie = result.getResult();
                    for(MdbMovie mdbMovie : movies){
                        movie.add(mdbMovie);
                    }
                    result.setResult(movie);
                }
            }

        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return result;
        }
    }

    /**
     * 当用户未为电影评过分时，直接按电影评分高低为用户推荐电影
     * @return 电影信息对象集合
     */
    public List<MdbMovie> searchMovie() {
        List<MdbMovie> list = null;
        try{
            list = sw.buildQuery()
                    .orderBy("star","desc")
                    .doQuery(MdbMovie.class);
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return list;
        }
    }
}
