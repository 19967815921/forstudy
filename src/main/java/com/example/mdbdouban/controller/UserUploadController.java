package com.example.mdbdouban.controller;


import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.service.MdbUserUploadService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@EnableTransactionManagement
@RestController
@RequestMapping("/upload")
public class UserUploadController {

    @Resource
    private MdbUserUploadService mdbUserUploadService;

    /**
     * 用户头像上传
     * @param filePath 文件路径
     * @return 是否上传成功
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    public Response userUpload(@RequestParam("filePath") String filePath){
        return Response.ok().data(mdbUserUploadService.doUpload(filePath));
    }
}
