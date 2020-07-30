package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.service.MovieSearchService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/search")
@EnableTransactionManagement
public class MovieSearchController {

    @Resource
    private MovieSearchService movieSearchService;

    /**
     * 电影信息查询
     * @param list 电影名，标签列表
     * @return 电影查询结果
     */
    @RequestMapping("/movie")
    @ResponseBody
    public Response movieSearch(@RequestBody List<String> list){
        return Response.ok().addListItem(movieSearchService.movieSearch(list));
    }

}
