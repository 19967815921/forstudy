package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.service.RecommendService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/recommend")
@EnableTransactionManagement
public class RecommendController {

    @Resource
    private RecommendService recommendService;

    /**
     * 推荐电影
     * @param id 用户id
     * @param page 页面数
     * @return 电影相关信息集合
     */
    @RequestMapping("/user")
    @ResponseBody
    public Response recommend(@RequestParam("id") Integer id,@RequestParam("page") Integer page){
        return Response.ok().addListItem(recommendService.recommend(id,page));
    }
}
