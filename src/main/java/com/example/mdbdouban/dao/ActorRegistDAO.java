package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbActor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class ActorRegistDAO {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 演员添加
     * @param actor 演员对象
     * @return 添加的演员对象
     */
    @Transactional
    public MdbActor regist(MdbActor actor) {
        MdbActor mdbActor = null;
        try{
            sw.buildQuery()
                    .doInsert(actor);
            mdbActor = actor;
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return mdbActor;
        }
    }
}
