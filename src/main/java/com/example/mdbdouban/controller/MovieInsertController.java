package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.service.MovieInsertService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/insert")
@EnableTransactionManagement
public class MovieInsertController {

    @Resource
    private MovieInsertService movieInsertService;

    /**
     * 电影信息插入
     * @param list 电影相关信息（演员列表，电影信息等）
     * @return 电影是否插入成功
     */
    @RequestMapping("/movie")
    @ResponseBody
    public Response movieInsert(@RequestBody List<Object> list){
        return Response.ok().addListItem(movieInsertService.movieInsert(list));
    }
}
