package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbComment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MovieCommentDAO {
    
    @Resource
    private MpaasQueryFactory sw;


    /**
     * 查询用户对该电影的评论
     * @param id 电影id
     * @return 评论集合
     */
    public List<MdbComment> searchMovieComment(Integer id) {
        List<MdbComment> list = null;
        try{
            list = sw.buildQuery()
                    .eq("movie_id",id)
                    .doQuery(MdbComment.class);
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return list;
        }
    }

    /**
     * 根据设定的等级查询电影评级的评论
     * @param id 电影id
     * @param grade 设定的等级
     * @return 相关等级的评论集合
     */
    public List<MdbComment> searchMovieGradeComment(Integer id, int grade) {
        List<MdbComment> list = null;
        try{
            if(grade == 5){
                list = sw.buildQuery()
                        .and()
                        .eq("movie_id",id)
                        .eq("star",5)
                        .doQuery(MdbComment.class);
            }else if(grade == 4){
                list = sw.buildQuery()
                        .and()
                        .eq("movie_id",id)
                        .eq("star",4)
                        .doQuery(MdbComment.class);
            }else if(grade == 3){
                list = sw.buildQuery()
                        .and()
                        .eq("movie_id",id)
                        .eq("star",3)
                        .doQuery(MdbComment.class);
            }else if(grade == 2){
                list = sw.buildQuery()
                        .and()
                        .eq("movie_id",id)
                        .eq("star",2)
                        .doQuery(MdbComment.class);
            }
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return list;
        }
    }
}
