package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbMovieTag;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class MovieTagDeleteDAO {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 电影标签删除
     * @param id 电影标签id
     * @return true 删除成功 false 删除失败
     */
    @Transactional
    public boolean tagDelete(Integer id) {
        boolean bool = false;
        try{
            sw.buildQuery()
                    .update("status","DISABLE")
                    .rowid("id", String.valueOf(id))
                    .doUpdate(MdbMovieTag.class);
            bool = true;
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }
}
