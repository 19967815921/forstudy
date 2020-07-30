package com.example.mdbdouban.controller;

import com.definesys.mpaas.common.http.Response;
import com.example.mdbdouban.service.MovieBillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/bill")
public class MovieBillController {

    @Resource
    private MovieBillService movieBillService;

    /**
     * 海报上传
     * @param filepath 文件路径
     * @param id 电影id
     * @return 上传是否成功
     */
    @RequestMapping("/movie")
    @ResponseBody
    public Response movieBill(@RequestParam("filepath") String filepath,@RequestParam("id") Integer id){
        return Response.ok().data(movieBillService.movieBill(filepath,id));
    }
}
