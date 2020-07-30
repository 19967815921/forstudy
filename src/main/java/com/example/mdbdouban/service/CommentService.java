package com.example.mdbdouban.service;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.example.mdbdouban.dao.CommentDAO;
import com.example.mdbdouban.pojo.MdbComment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {

    @Resource
    private CommentDAO dao;

    /**
     * 用户评论
     * @param mdbComment 评论对象
     * @return 是否评论成功
     */
    public boolean userComment(MdbComment mdbComment) {
        boolean bool = false;
        if(mdbComment.getUserId() == null || dao.searchUserId(String.valueOf(mdbComment.getUserId()))){
            throw new MpaasBusinessException("用户未登录,或非法传值");
        }else{
            bool = dao.userComment(mdbComment);
        }
        return bool;
    }
}
