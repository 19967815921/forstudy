package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbMovieTag;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class MovieAddTagDAO {

    @Resource
    private MpaasQueryFactory sw;


    /**
     * 电影标签添加
     * @param mdbMovieTag 电影标签
     * @return 添加是否成功
     */
    @Transactional
    public boolean movieAddTag(MdbMovieTag mdbMovieTag) {
        boolean bool = false;
        try{
            sw.buildQuery()
                    .doInsert(mdbMovieTag);
            bool = true;
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }

}
