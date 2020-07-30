package com.example.mdbdouban.service;

import com.example.mdbdouban.dao.ActorRegistDAO;
import com.example.mdbdouban.pojo.MdbActor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ActorRegistService {

    @Resource
    private ActorRegistDAO dao;

    /**
     * 增加演员信息
     * @param mdbActor 演员对象
     * @return 执行是否成功信息
     */
    public String actorRegist(MdbActor mdbActor) {
        String Msg = "ACTOR REGIST FAILED";
        if(dao.regist(mdbActor) != null){
            Msg = "ACTOR REGIST SUCCESS";
        }
        return Msg;
    }
}
