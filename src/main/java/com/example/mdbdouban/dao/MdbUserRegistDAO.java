package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbUser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MdbUserRegistDAO {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 用户注册
     * @param mdbUser 用户对象
     * @return 是否注册成功
     */
    @Transactional
    public boolean regist(MdbUser mdbUser) {
        boolean bool = false;
        try{
            sw.buildQuery()
                    .doInsert(mdbUser);
            List<MdbUser> list = sw.buildQuery()
                    .eq("nickname",mdbUser.getNickname())
                    .doQuery(MdbUser.class);
            sw.buildQuery()
                    .rowid("account", String.valueOf(list.get(1).getId()))
                    .doUpdate(MdbUser.class);
            bool = true;
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally{
            return bool;
        }
    }

    /**
     * 查找电话是否已经注册
     * @param phone 电话
     * @return 是否已注册
     */
    public boolean searchPhone(String phone) {
        boolean bool = false;
        List<MdbUser> depandPhone = sw.buildQuery()
                .eq("phone",phone)
                .doQuery(MdbUser.class);
        if(depandPhone.size() > 0){
            bool = true;
        }
        return bool;
    }

    /**
     * 昵称是否存在
     * @param nickname 用户昵称
     * @return 是否存在
     */
    public boolean searchNickname(String nickname) {
        boolean bool = false;
        List<MdbUser> depandNickname = sw.buildQuery()
                .eq("nickname",nickname)
                .doQuery(MdbUser.class);
        if(depandNickname.size() > 0){
            bool = true;
        }
        return bool;
    }
}
