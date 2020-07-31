package com.example.mdbdouban.service;

import com.example.mdbdouban.dao.ActorRegistDAO;
import com.example.mdbdouban.pojo.MdbActor;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ActorRegistService {

    @Resource
    private ActorRegistDAO dao;

    private static final Logger logger = LoggerFactory.getLogger(ActorRegistService.class);

    public static void main(String[] args) {
        logger.info("hello {}","world！！！！");
    }
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
