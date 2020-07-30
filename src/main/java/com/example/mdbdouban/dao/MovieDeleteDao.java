package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbMovie;
import com.example.mdbdouban.pojo.MdbMovieActorRel;
import com.example.mdbdouban.pojo.MdbMovieTagRel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MovieDeleteDao {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 电影是否存在
     * @param id 电影id
     * @return true 存在 false 不存在
     */
    public boolean searchMovieId(Integer id) {
        boolean bool = false;
        try {
            List<MdbMovie> list = sw.buildQuery()
                    .eq("id",id)
                    .doQuery(MdbMovie.class);
            bool = true;
        }catch (Exception e){
            throw  new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }

    /**
     * 电影删除
     * @param id 电影id
     * @return true 删除成功 false 删除失败
     */
    @Transactional
    public boolean movieDelete(Integer id) {
        boolean bool = false;
        try {
             sw.buildQuery()
                    .eq("id",id)
                    .doDelete(MdbMovie.class);
             sw.buildQuery()
                     .eq("movieId",id)
                     .doDelete(MdbMovieTagRel.class);
             sw.buildQuery()
                     .eq("movieId",id)
                     .doDelete(MdbMovieActorRel.class);
            bool = true;
        }catch (Exception e){
            throw  new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }
}
