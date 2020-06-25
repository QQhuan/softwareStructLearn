package com.qiuhuan.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.qiuhuan.sportplay.Dao.GoodDao;
import com.qiuhuan.sportplay.bean.Good;
import com.qiuhuan.sportplay.bean.QueryInfo;
import com.qiuhuan.sportplay.bean.User;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
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

    private  final String URL = "http://localhost:9000/";

    @PostMapping("/upload/{id}")
    public String uploadFile(@RequestParam(value = "file", required = false) MultipartFile multipartFile,  @PathVariable("id") int id) throws IOException {
        String FILE_PATH = "src/main/resources/static/img/";
        String fileName = multipartFile.getOriginalFilename();
        String suffix = ".png";
        File directory = new File(FILE_PATH);
        if (!directory.exists()) directory.mkdirs();  // 判断文件夹是否存在，不存在则创建
        String filePath = FILE_PATH + UUID.randomUUID().toString() + suffix;
        File file = new File(filePath);
        FileOutputStream outputStream = new FileOutputStream(file);
        IOUtils.copy(multipartFile.getInputStream(), outputStream); // 写入文件流
        outputStream.close();
        //存储img路径到数据库
        int i = goodDao.addImg(id, filePath);

        //返回图片访问地址
        System.out.println("访问URL：" + URL + fileName);
        String str = i > 0 ? "success" : "error";
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


//    @RequestMapping("upload2")
//    public String upload2(HttpSession session, @RequestParam("upload") CommonsMultipartFile file) throws IOException {
//
//        ServletContext application=session.getServletContext();
////        获取要存放图片的upload文件夹的全路径
//        String serverPath=application.getRealPath("upload");
////        获取接收到的图片的文件全名
//        String fileName=file.getOriginalFilename();
////        获取图片的后缀名
//        String extentName=fileName.substring(fileName.lastIndexOf("."),fileName.length());
////        重命名该图片(避免重名
//        String uuid= UUID.randomUUID().toString();
//        String onlyName=uuid+extentName;
////        将重名后的图片存入到对应路径
//        file.transferTo(new File(serverPath,onlyName));
//
//        return "redirect:../view/up.jsp";
//    }
}
