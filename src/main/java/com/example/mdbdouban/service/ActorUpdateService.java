package com.example.mdbdouban.service;

import com.example.mdbdouban.dao.ActorUpdateDAO;
import com.example.mdbdouban.pojo.MdbActor;
import com.example.mdbdouban.pojo.MdbUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActorUpdateService {

    @Resource
    private ActorUpdateDAO dao;

    /**
     * 更新演员信息
     * @param mdbActor 演员对象
     * @return 执行是否成功信息
     */
    public Integer actorUpdate(MdbActor mdbActor) {

        return dao.actorUpdate(mdbActor);
    }

}
