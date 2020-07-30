package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.service.UserSearchAllService;
import org.hibernate.validator.internal.util.IgnoreJava6Requirement;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/search")
@EnableTransactionManagement
public class UserSearchAllController {

    @Resource
    private UserSearchAllService userSearchAllService;

    /**
     * 查询用户信息
     * @return 用户信息
     */
    @RequestMapping(value = "/all")
    @ResponseBody
    public Response searchAllUser(){

        return Response.ok().addListItem(userSearchAllService.searchAllUser());
    }
}
