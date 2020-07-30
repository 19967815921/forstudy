package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.pojo.MdbMovie;
import com.example.mdbdouban.service.MovieTagUpdateService;
import com.example.mdbdouban.service.MovieUpdateService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/update")
@EnableTransactionManagement
public class MovieUpdateController {

    @Resource
    private MovieUpdateService movieUpdateService;

    /**
     * 电影信息更新
     * @param mdbMovie 电影对象
     * @return 更新电影相关信息
     */
    @RequestMapping("movie")
    @ResponseBody
    public Response movieUpdate(@RequestBody MdbMovie mdbMovie){
        return Response.ok().addListItem(movieUpdateService.movieUpdate(mdbMovie));
    }
}
