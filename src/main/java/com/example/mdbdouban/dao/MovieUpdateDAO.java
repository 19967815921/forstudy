package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbMovie;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class MovieUpdateDAO {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 电影信息更新
     * @param mdbMovie 电影信息对象
     * @return true 更新成功 false 更新失败
     */
    @Transactional
    public Boolean movieUpdate(MdbMovie mdbMovie) {
        Boolean bool = false;
        try {
            sw.buildQuery()
                    .rowid("id", String.valueOf(mdbMovie.getId()))
                    .doUpdate(mdbMovie);
            bool =true;
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }
}
