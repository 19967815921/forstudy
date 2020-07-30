package com.example.mdbdouban.service;

import com.example.mdbdouban.dao.UserSearchAllDAO;
import com.example.mdbdouban.pojo.MdbUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserSearchAllService {

    @Resource
    private UserSearchAllDAO dao;

    /**
     * 查询用户信息
     * @return 用户信息集合
     */
    public List<MdbUser> searchAllUser() {
        List<MdbUser> list;
        list = dao.searchAll();
        return list;
    }
}
