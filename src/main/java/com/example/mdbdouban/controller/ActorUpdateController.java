package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.pojo.MdbActor;
import com.example.mdbdouban.service.ActorUpdateService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/update")
@EnableTransactionManagement
public class ActorUpdateController {

    @Resource
    private ActorUpdateService actorUpdateService;

    /**
     * 更新演员信息
     * @param mdbActor 传入更新后演员对象
     * @return 是否更新演员信息成功
     */
    @RequestMapping("/actor")
    @ResponseBody
    public Response actorUpdate(@RequestParam MdbActor mdbActor){
        return Response.ok().addListItem(actorUpdateService.actorUpdate(mdbActor));
    }
}
