package com.example.mdbdouban.service;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.dao.MdbUserLoginDAO;
import com.example.mdbdouban.dao.MdbUserRegistDAO;
import com.example.mdbdouban.pojo.MdbUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MdbUserLoginService {

    @Resource
    MpaasQueryFactory sw;

    @Resource
    private MdbUserLoginDAO dao;

    /**
     * 用户登录
     * @param account 用户账号
     * @param password 用户密码
     * @return 是否登录成功
     */
    public MdbUser doLogin(String account, String password) {
        if(dao.searchAccount(account)){
            throw new MpaasBusinessException("账号不存在！");
        }
        return dao.login(account,password);
    }
}
