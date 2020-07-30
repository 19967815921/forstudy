package com.example.mdbdouban.service;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.example.mdbdouban.dao.MovieDeleteDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MovieDeleteService {

    @Resource
    private MovieDeleteDao dao;

    /**
     * 电影信息删除
     * @param id 电影id
     * @return 是否删除成功
     */
    public boolean movieDelete(Integer id) {
        boolean bool = false;
        if(dao.searchMovieId(id)){
            bool = dao.movieDelete(id);
        }else{
            throw new MpaasBusinessException("没有该电影信息！") ;
        }
        return bool;
    }
}
