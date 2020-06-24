package com.qiuhuan.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.qiuhuan.sportplay.Dao.GoodDao;
import com.qiuhuan.sportplay.bean.Good;
import com.qiuhuan.sportplay.bean.QueryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

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
