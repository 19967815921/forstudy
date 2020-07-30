package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbActor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ActorUpdateDAO {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 演员信息更新
     * @param mdbActor 演员信息对象
     * @return 修改信息数量
     */
    @Transactional
    public Integer actorUpdate(MdbActor mdbActor) {
        Integer num = null;
        try{
            num = sw.buildQuery()
                    .rowid("id",String.valueOf(mdbActor.getId()))
                    .doUpdate(mdbActor);
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return num;
        }
    }

}
