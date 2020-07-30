package com.example.mdbdouban.service;

import com.example.mdbdouban.dao.ActorDeleteDAO;
import org.springframework.stereotype.Service;
import sun.applet.resources.MsgAppletViewer;

import javax.annotation.Resource;

@Service
public class ActorDeleteService {

    @Resource
    private ActorDeleteDAO dao;


    /**
     * 删除演员信息
     * @param id 演员id
     * @return 执行是否成功信息
     */
    public String actorDelete(Integer id) {
        String Msg = null;
        dao.actorDelete(id);

        return Msg;
    }
}
