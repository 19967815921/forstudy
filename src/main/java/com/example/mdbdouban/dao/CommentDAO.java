package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbComment;
import com.example.mdbdouban.pojo.MdbMovie;
import com.example.mdbdouban.pojo.MdbUser;
import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
public class CommentDAO {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 用户是否存在
     * @param s 用户id
     * @return 是否存在
     */
    public boolean searchUserId(String s) {
        boolean bool = false;
        try{
            List<MdbUser> list = sw.buildQuery()
                    .eq("id",s)
                    .doQuery(MdbUser.class);
            if(list.size() > 0){
                bool = true;
            }
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }

    /**
     * 用户评论
     * @param mdbComment 评论对象
     * @return 是否添加成功
     */
    @Transactional
    public boolean userComment(MdbComment mdbComment) {
        boolean bool = false;
        try{
            mdbComment.setUserId(Integer.valueOf(mdbComment.getUserId()));
            mdbComment.setMovieId(Integer.valueOf(mdbComment.getMovieId()));
            mdbComment.setContent(mdbComment.getContent());
            mdbComment.setStar(Integer.valueOf(mdbComment.getStar()));
            sw.buildQuery()
                    .doInsert(mdbComment);
            List<MdbComment> list = sw.buildQuery()
                    .eq("movie_id",mdbComment.getMovieId())
                    .doQuery(MdbComment.class);
            Double stars = 0.0;
            for(MdbComment mdbc : list){
                stars += mdbc.getStar();
            }
            stars /= list.size();
            sw.buildQuery()
                    .update("star",stars)
                    .rowid("id", String.valueOf(mdbComment.getMovieId()))
                    .doUpdate(MdbMovie.class);
            bool = true;
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }
}
