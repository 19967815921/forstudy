package com.example.mdbdouban.service;

import com.example.mdbdouban.dao.MovieCommentDAO;
import com.example.mdbdouban.pojo.MdbComment;
import org.springframework.stereotype.Service;
import sun.applet.resources.MsgAppletViewer;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieCommentService {

    @Resource
    private MovieCommentDAO dao;

    /**
     * 电影评分
     * @param id 电影id
     * @return 电影评分信息
     */
    public String movieComment(Integer id) {
        StringBuffer Msg = new StringBuffer();
        Double star;
        int commentNum;
        int fiveCommentNum;
        int fourCommentNum;
        int threeCommentNum;
        int twoCommentNum;
        commentNum = dao.searchMovieComment(id).size();
        fiveCommentNum = dao.searchMovieGradeComment(id,5).size();
        fourCommentNum = dao.searchMovieGradeComment(id,4).size();
        threeCommentNum = dao.searchMovieGradeComment(id,3).size();
        twoCommentNum = dao.searchMovieGradeComment(id,2).size();
        star = Double.valueOf(fiveCommentNum*5 + fourCommentNum*4 + threeCommentNum*3 + twoCommentNum*2 + (commentNum-fiveCommentNum-fourCommentNum-threeCommentNum-twoCommentNum)*1);
        Msg.append("分数：")
                .append(star)
                .append("五星百分比：")
                .append(fiveCommentNum/commentNum)
                .append("四星百分比：")
                .append(fourCommentNum/commentNum)
                .append("三星百分比：")
                .append(threeCommentNum/commentNum)
                .append("二星百分比：")
                .append(twoCommentNum/commentNum)
                .append("一星百分比：")
                .append((commentNum - fiveCommentNum - fourCommentNum - threeCommentNum - twoCommentNum)/commentNum);
        return String.valueOf(Msg);
    }
}
