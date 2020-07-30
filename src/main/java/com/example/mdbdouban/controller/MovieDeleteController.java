package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.service.MovieDeleteService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.naming.InsufficientResourcesException;

@RestController
@RequestMapping("/delete")
@EnableTransactionManagement
public class MovieDeleteController {

    @Resource
    private MovieDeleteService movieTagDeleteService;

    /**
     * 电影信息删除
     * @param id 电影id
     * @return 电影是否删除成功
     */
    @RequestMapping("/movie")
    @ResponseBody
    public Response movieDelete(@RequestParam("id") Integer id){
        return Response.ok().data(movieTagDeleteService.movieDelete(id));
    }
}
