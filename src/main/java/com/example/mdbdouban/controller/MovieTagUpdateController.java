package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.service.MovieTagUpdateService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/update")
@EnableTransactionManagement
public class MovieTagUpdateController {

    @Resource
    private MovieTagUpdateService movieTagUpdateService;

    /**
     * 电影标签更新
     * @param id 电影标签id,更新标签名
     * @param tagName 更新标签名
     * @return 是否更新成功
     */
    @RequestMapping("/movieTag")
    @ResponseBody
    public Response movieTagUpdate(@RequestParam("id") Integer id,@RequestParam("tagName") String tagName){
        return Response.ok().data(movieTagUpdateService.movieTagUpdate(id,tagName));
    }
}
