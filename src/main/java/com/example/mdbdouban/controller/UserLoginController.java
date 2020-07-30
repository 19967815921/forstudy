package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.service.MdbUserLoginService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
@EnableTransactionManagement
public class UserLoginController {

    @Resource
    MdbUserLoginService mdbUserLoginService;

    /**
     * 用户登录
     * @param account 用户账号
     * @param password 用户密码
     * @return 登录是否成功
     */
    @RequestMapping("/user")
    @ResponseBody
    public Response userLogin(@RequestParam("account") String account, @RequestParam("password") String password){
        return Response.ok().addListItem(mdbUserLoginService.doLogin(account,password));
    }
}
