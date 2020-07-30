package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbUser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MdbUserLoginDAO {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 用户登录
     * @param account 用户账号
     * @param password 用户密码
     * @return 登录用户信息对象
     */
    public MdbUser login(String account, String password) {
        List<MdbUser> list = null;
        try{
            list = sw.buildQuery()
                    .and()
                    .eq("account",account)
                    .eq("password",password)
                    .doQuery(MdbUser.class);
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return list.get(1);
        }
    }

    /**
     * 查询用户账号是否存在
     * @param account 用户账号
     * @return 是否存在
     */
    public boolean searchAccount(String account) {
        boolean bool = false;
        List<MdbUser> depandAccount = sw.buildQuery()
                .eq("phone",account)
                .doQuery(MdbUser.class);
        if(depandAccount.size() > 0){
            bool = true;
        }
        return bool;
    }
}
