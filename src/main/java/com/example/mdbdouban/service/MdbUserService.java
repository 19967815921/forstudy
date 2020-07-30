package com.example.mdbdouban.service;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.dao.MdbUserRegistDAO;
import com.example.mdbdouban.pojo.MdbUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MdbUserService {

    @Resource
    private MdbUserRegistDAO dao;

    /**
     * 用户注册
     * @param mdbUser 用户对象
     * @return 是否注册成功
     */
    public String doRegist(MdbUser mdbUser) {
        StringBuffer Msg = new StringBuffer();
        if(dao.searchPhone(mdbUser.getPhone())){
            Msg.append("<h2>手机号重复注册。</h2><br>");
            throw new MpaasBusinessException("数据不合法,手机号重复注册。");
        }
        if(dao.searchNickname(mdbUser.getNickname())){
            Msg.append("<h2>昵称重复注册。</h2><br>");
            throw new MpaasBusinessException("数据不合法,昵称重复注册。");
        }
        if(!dao.searchPhone(mdbUser.getPhone()) && !dao.searchNickname(mdbUser.getNickname())){
            if(dao.regist(mdbUser)){
                Msg.append("<h1>REGIST SUCCESS</h1><br>");
            }
        }
        return Msg.toString();
    }
}
