package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.service.MovieTagDeleteService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/delete")
@EnableTransactionManagement
public class MovieTagDeleteController {

    @Resource
    private MovieTagDeleteService movieTagDeleteService;

    /**
     * 电影标签删除
     * @param id 电影标签id
     * @return 是否删除成功
     */
    @RequestMapping("/movieTag")
    @ResponseBody
    public Response movieTagDelete(@RequestParam("id")Integer id){
        return Response.ok().data(movieTagDeleteService.tagDelete(id));
    }
}
