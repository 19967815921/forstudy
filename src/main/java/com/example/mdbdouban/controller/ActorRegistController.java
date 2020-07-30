package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.pojo.MdbActor;
import com.example.mdbdouban.service.ActorRegistService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/regist")
@EnableTransactionManagement
public class ActorRegistController {

    @Resource
    private ActorRegistService actorRegistService;

    /**
     * 注册演员
     * @param mdbActor 传入演员对象
     * @return 是否添加演员信息成功
     */
    @RequestMapping("/actor")
    @ResponseBody
    public Response actorRegist(@RequestBody MdbActor mdbActor){
        return Response.ok().data(actorRegistService.actorRegist(mdbActor));
    }
}
