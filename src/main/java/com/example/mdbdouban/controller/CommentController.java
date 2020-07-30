package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.pojo.MdbComment;
import com.example.mdbdouban.service.CommentService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comment")
@EnableTransactionManagement
public class CommentController {

    @Resource
    private CommentService commentService;

    /**
     * 增加评论
     * @param mdbComment 评论对象
     * @return 是否增加成功
     */
    @RequestMapping("/user")
    @ResponseBody
    public Response userComment(@RequestBody MdbComment mdbComment){
        return Response.ok().data(commentService.userComment(mdbComment));
    }

}
