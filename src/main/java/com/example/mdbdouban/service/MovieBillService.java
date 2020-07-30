package com.example.mdbdouban.service;

import com.definesys.mpaas.common.exception.MpaasBusinessException;
import com.example.mdbdouban.dao.movieBillDAO;
import com.example.mdbdouban.pojo.MdbAttachment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;

@Service
public class MovieBillService {

    @Resource
    private movieBillDAO dao;

    /**
     * 海报上传
     * @param filepath 文件路径
     * @param id 电影id
     * @return true 添加成功 false 添加失败
     */
    public Boolean movieBill(String filepath,Integer id) {
        Boolean bool = false;
        MdbAttachment mdbAttachment = getMdbAttachment(filepath);
        if(dao.upload(mdbAttachment,id)){
            bool = true;
        }
        return bool;
    }

    /**
     * 获得添加的附件对象的部分信息
     * @param filePath 文件路径
     * @return  附件对象
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
