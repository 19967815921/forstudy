package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.pojo.MdbActor;
import com.example.mdbdouban.service.ActorSearchService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/search")
@EnableTransactionManagement
public class ActorSearchController {

    @Resource
    private ActorSearchService actorSearchService;

    @RequestMapping("/actor")
    @ResponseBody
    public Response actorSearch(@RequestBody MdbActor mdbActor){
        return Response.ok().addListItem(actorSearchService.actorSearch(mdbActor));
    }
}
