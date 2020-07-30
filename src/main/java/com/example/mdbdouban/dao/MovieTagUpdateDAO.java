package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbMovieTag;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class MovieTagUpdateDAO {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 电影标签更新
     * @param id 电影标签id
     * @param tagName  标签名称
     * @return true 更新成功 false 更新失败
     */
    @Transactional
    public Boolean movieTagUpdate(Integer id, String tagName) {
        boolean bool = false;
        try {
           sw.buildQuery()
                   .update("tagName",tagName)
                   .rowid("id", String.valueOf(id))
                   .doUpdate(MdbMovieTag.class);
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }
}
