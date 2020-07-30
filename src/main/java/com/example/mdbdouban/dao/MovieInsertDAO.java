package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbMovie;
import com.example.mdbdouban.pojo.MdbMovieActorRel;
import com.example.mdbdouban.pojo.MdbMovieTag;
import com.example.mdbdouban.pojo.MdbMovieTagRel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class MovieInsertDAO {

    @Resource
    private MpaasQueryFactory sw;


    /**
     * 电影信息添加
     * @param mdbMovie 电影信息对象
     * @return true 添加成功 false 添加失败
     */
    @Transactional
    public boolean movieInsert(MdbMovie mdbMovie) {
        boolean bool = false;
        try{
            sw.buildQuery()
                    .doInsert(mdbMovie);
            bool = true;
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }

    /**
     * 添加演员电影关系表
     * @param actors 演员信息数组
     * @param mdbMovie 电影信息
     * @return true 添加成功 false 添加失败
     */
    @Transactional
    public boolean setActors(String[][] actors,MdbMovie mdbMovie){
        Boolean bool = false;
        try{
            for(int i = 0;i < actors.length;i++){
                MdbMovieActorRel mdbMovieActorRel = new MdbMovieActorRel();
                for(int j = 0;j < actors[i].length;j++){
                    mdbMovieActorRel.setActorId(Integer.valueOf(actors[i][j]));
                    mdbMovieActorRel.setRole(actors[i][j]);
                    mdbMovieActorRel.setMovieId(mdbMovie.getId());
                    sw.buildQuery()
                            .doInsert(mdbMovieActorRel);
                }
            }
            bool = true;
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }

    /**
     * 添加电影标签关系表
     * @param movieTagsRel  电影标签信息数组
     * @param mdbMovie 电影对象
     * @return true 添加成功 false 添加失败
     */
    @Transactional
    public boolean setMovieTagsRel(String[] movieTagsRel,MdbMovie mdbMovie){
        Boolean bool = false;
        try{
            for(int i = 0;i < movieTagsRel.length;i++){
                MdbMovieTagRel mdbMovieTagRel = new MdbMovieTagRel();
                mdbMovieTagRel.setTagId(Integer.valueOf(movieTagsRel[i]));
                mdbMovieTagRel.setMovieId(mdbMovie.getId());
                sw.buildQuery()
                        .doInsert(mdbMovieTagRel);
            }
            bool = true;
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }
}
