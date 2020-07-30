package com.example.mdbdouban.dao;

import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbUser;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserSearchAllDAO {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 用户查找
     * @return 用户信息对象
     */
    public List<MdbUser> searchAll() {
        List<MdbUser> list;
        list = sw.buildQuery()
                .doQuery(MdbUser.class);
        return list;
    }
}
