package com.example.mdbdouban.service;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.example.mdbdouban.dao.MdbUserUploadDAO;
import com.example.mdbdouban.pojo.MdbAttachment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;

@Service
public class MdbUserUploadService {

    @Resource
    private MdbUserUploadDAO dao;


    /**
     * 用户上传头像
     * @param filePath 文件路径
     * @return 是否上传成功
     */
    public Boolean doUpload(String filePath) {
        Boolean bool = false;
        MdbAttachment mdbAttachment = getMdbAttachment(filePath);
        if(dao.upload(mdbAttachment)){
            bool = true;
        }
        return bool;
    }

    /**
     * 添加附件
     * @param filePath 文件路径
     * @return 添加附件对象
     */
    private MdbAttachment getMdbAttachment(String filePath) {
        MdbAttachment mdbAttachment = null;
        File file = new File(filePath);
        if(!file.isFile()){
            throw new MpaasBusinessException("未获得文件！");
        }else{
            String fileName = file.getName();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            mdbAttachment.setAttachmentName(fileName);
            mdbAttachment.setUuid(filePath);
        }
        return mdbAttachment;
    }
}
