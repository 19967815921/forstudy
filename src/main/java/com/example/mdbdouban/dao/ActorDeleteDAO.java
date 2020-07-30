package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbActor;
import com.example.mdbdouban.pojo.MdbMovieActorRel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class ActorDeleteDAO {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 删除演员信息
     * @param id 演员id
     * @return 是否删除成功
     */
    @Transactional
    public boolean actorDelete(Integer id) {
        boolean bool = false;
        try {
            sw.buildQuery()
                    .eq("id",id)
                    .doDelete(MdbActor.class);
            movieDelete(id);
            bool = true;
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }

    /**
     * 电影信息演员关系表数据删除
     * @param id 演员信息
     * @return  是否删除
     */
    @Transactional
    public boolean movieDelete(Integer id) {
        boolean bool = false;
        try{
            sw.buildQuery()
                    .eq("actor_id",id)
                    .doDelete(MdbMovieActorRel.class);
            bool = true;
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }
}
