package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.pojo.MdbMovieTag;
import com.example.mdbdouban.service.MovieTagAddService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/movie")
@EnableTransactionManagement
public class MovieTagAddController {

    @Resource
    private MovieTagAddService movieTagAddService;

    /**
     * 电影标签添加
     * @param mdbMovieTag 电影标签对象
     * @return 是否添加成功
     */
    @RequestMapping("/add")
    @ResponseBody
    public Response movieTagAdd(@RequestBody MdbMovieTag mdbMovieTag){
        return Response.ok().data(movieTagAddService.movieAdd(mdbMovieTag));
    }
}
