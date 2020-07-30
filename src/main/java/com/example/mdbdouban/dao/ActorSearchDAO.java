package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbActor;
import com.example.mdbdouban.pojo.MdbUser;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ActorSearchDAO {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 模糊查询演员信息
     * @param name 演员姓名
     * @return 演员信息集合
     */
    public List<MdbActor> searchActorName(String name) {
        List<MdbActor> list = null;
        try{
            list = sw.buildQuery()
                    .likeNocase("name",name)
                    .doQuery(MdbActor.class);
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return list;
        }
    }

    /**
     * 通过拼音模糊查询演员信息
     * @param pinyin 演员姓名拼音
     * @return 演员信息集合
     */
    public List<MdbActor> searchActorPinyin(String pinyin) {
        List<MdbActor> list = null;
        try{
            list = sw.buildQuery()
                    .likeNocase("pinyin",pinyin)
                    .doQuery(MdbActor.class);
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return list;
        }
    }
}
