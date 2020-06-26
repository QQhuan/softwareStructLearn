package com.qiuhuan.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.qiuhuan.sportplay.Dao.GoodDao;
import com.qiuhuan.sportplay.bean.Good;
import com.qiuhuan.sportplay.bean.QueryInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
public class GoodController {

    @Autowired
    GoodDao goodDao;

    //    获取商品列表
    @GetMapping("/good")
    public String getGoodList(QueryInfo queryInfo){
        int numbers = goodDao.getGoodCount();// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<Good> goods = goodDao.getAllGood(pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data", goods);
        System.out.println("总条数："+numbers);
        String data_json = JSON.toJSONString(res);
        return data_json;
    }

    //增加商品
    @PostMapping("/good")
    public String addGood(@RequestBody Good good){
        System.out.println(good);
        good.setImg(""); //图片暂时不写
        int i = goodDao.addNewGood(good);
        String str = i > 0?"success":"error";
        return str;
    }

    //删除商品
    @DeleteMapping(value = "/good/{id}")
    public String deleteGood(@PathVariable("id") int id){
        System.out.println(id);
        int i = goodDao.deleteGood(id);
        String str = i > 0?"success":"error";
        return str;
    }

    //修改商品信息
    @PutMapping("/good")
    public String updateGood(@RequestBody Good good){
        System.out.println(good);
        int i = goodDao.updateGood(good);
        String str = i > 0?"success":"error";
        return str;
    }


    @PostMapping("/upload/{id}")
    public String uploadFile(@RequestParam(value = "file", required = false) MultipartFile multipartFile, @PathVariable("id") int id) throws IOException {
        String FILE_PATH = "src/main/resources/static/img/";
        String originalFilename = multipartFile.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.indexOf("."));
        File directory = new File(FILE_PATH);
        if(!directory.exists()) directory.mkdirs();  // 判断文件夹是否存在，不存在则创建
        String filePath = FILE_PATH + UUID.randomUUID().toString() + suffix;
        File file = new File(filePath);
        FileOutputStream outputStream = new FileOutputStream(file);
        IOUtils.copy(multipartFile.getInputStream(), outputStream); // 写入文件流
        outputStream.close();
        //存储img路径到数据库
        int i = goodDao.addImg(id, filePath);
        String str = i > 1?"success":"error";
        return str;
    }
    @GetMapping("/getFile")
    public void getFile(@RequestParam("path") String path, HttpServletResponse response) throws IOException{
        String filePath = path;
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
        outputStream.flush();
    }
}
