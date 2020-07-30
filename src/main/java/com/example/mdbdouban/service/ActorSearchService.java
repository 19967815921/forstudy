package com.example.mdbdouban.service;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.example.mdbdouban.dao.ActorSearchDAO;
import com.example.mdbdouban.pojo.MdbActor;
import com.example.mdbdouban.pojo.MdbUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActorSearchService {

    @Resource
    private ActorSearchDAO dao;

    /**
     * 查询演员信息
     * @param mdbActor 演员对象
     * @return 查询后的演员信息集合
     */
    public List<MdbActor> actorSearch(MdbActor mdbActor) {
        List<MdbActor> list = null;
        String name;
        String pinyin;
        if((name = mdbActor.getName()) != null) {
            if((list = dao.searchActorName(name)).size() == 0){
                throw new MpaasBusinessException("未查找到类似名字的人员");
            }
        }else if((pinyin = mdbActor.getPinyin()) != null){
            if((list = dao.searchActorPinyin(pinyin)).size() == 0){
                throw new MpaasBusinessException("未查找到类似拼音的人员");
            }
        }
        return list;
    }
}
