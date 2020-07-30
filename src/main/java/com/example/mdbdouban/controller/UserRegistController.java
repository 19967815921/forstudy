package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbUser;
import com.example.mdbdouban.service.MdbUserService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@EnableTransactionManagement
@RestController
@RequestMapping("/regist")
public class UserRegistController {

    @Resource
    MdbUserService mdbUserService;

    /**
     * 用户登录
     * @param mdbUser 用户对象
     * @return 用户注册是否成功
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    public Response userRegist(@RequestBody MdbUser mdbUser){
        return Response.ok().data(mdbUserService.doRegist(mdbUser));
    }
}
