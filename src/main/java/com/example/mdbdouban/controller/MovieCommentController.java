package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.service.MovieCommentService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/comment")
@EnableTransactionManagement
public class MovieCommentController {

    @Resource
    private MovieCommentService movieCommentService;

    /**
     * 影片评分信息查询
     * @param id 影片id
     * @return 影片评分相关信息
     */
    @RequestMapping("/movie")
    @ResponseBody
    public Response movieComment(@RequestParam("id")Integer id){
        return Response.ok().data(movieCommentService.movieComment(id));
    }
}
