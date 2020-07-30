package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbAttachment;
import com.example.mdbdouban.pojo.MdbMovie;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
public class movieBillDAO {

    @Resource
    private MpaasQueryFactory sw;


    /**
     * 海报附件添加
     * @param mdbAttachment 电影附件对象
     * @return 添加是否成功
     */
    @Transactional
    public boolean upload(MdbAttachment mdbAttachment,Integer id) {
        boolean bool = false;
        try {
            sw.buildQuery()
                    .doInsert(mdbAttachment);
            List<MdbAttachment> list = sw.buildQuery()
                    .eq("attachment_name",mdbAttachment.getAttachmentName())
                    .doQuery(MdbAttachment.class);
            sw.buildQuery()
                    .rowid("id", String.valueOf(id))
                    .update("avatar",list.get(1).getId())
                    .doUpdate(MdbMovie.class);
            bool = true;
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }
}
