package com.example.mdbdouban.dao;

import com.definesys.mpaas.common.exception.MpaasRuntimeException;
import com.definesys.mpaas.query.MpaasQueryFactory;
import com.example.mdbdouban.pojo.MdbAttachment;
import com.example.mdbdouban.pojo.MdbUser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MdbUserUploadDAO {

    @Resource
    private MpaasQueryFactory sw;

    /**
     * 头像上传
     * @param mdbAttachment 附件信息
     * @return 是否上传成功
     */
    @Transactional
    public boolean upload(MdbAttachment mdbAttachment){
        boolean bool = false;
        try {
            sw.buildQuery()
                    .doInsert(mdbAttachment);
            List<MdbAttachment> list = sw.buildQuery()
                    .eq("attachment_name",mdbAttachment.getAttachmentName())
                    .doQuery(MdbAttachment.class);
            sw.buildQuery()
                    .update("avatar",list.get(1).getId());
            bool = true;
        }catch (Exception e){
            throw new MpaasRuntimeException(e);
        }finally {
            return bool;
        }
    }
}
