package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.service.ActorDeleteService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/delete")
@EnableTransactionManagement
public class ActorDeleteController {

    @Resource
    private ActorDeleteService actorDeleteService;

    /**
     * 删除演员信息
     * @param id 演员id
     * @return 是否删除成功
     */
    @RequestMapping("/actor")
    @ResponseBody
    public Response actorDelete(@RequestParam("id") Integer id){
        return Response.ok().data(actorDeleteService.actorDelete(id));
    }
}
