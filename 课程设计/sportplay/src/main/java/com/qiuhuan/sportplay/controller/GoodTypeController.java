package com.qiuhuan.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.qiuhuan.sportplay.Dao.GoodTypeDao;
import com.qiuhuan.sportplay.bean.Good;
import com.qiuhuan.sportplay.bean.GoodType;
import com.qiuhuan.sportplay.bean.QueryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class GoodTypeController {
    @Autowired
    GoodTypeDao goodTypeDao;

    @GetMapping("/goodType")
    public String getGoodList(QueryInfo queryInfo){
        int numbers = goodTypeDao.getGoodTypeCount();// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<GoodType> goodTypes = goodTypeDao.getAllGoodType(pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data", goodTypes);
        System.out.println("总条数："+numbers);
        String data_json = JSON.toJSONString(res);
        return data_json;
    }

    @PostMapping("/goodType")
    public String addGood(@RequestBody GoodType goodType){
        System.out.println(goodType);
        int i = goodTypeDao.addNewGoodType(goodType);
        String str = i > 0?"success":"error";
        return str;
    }

    @DeleteMapping(value = "/goodType/{id}")
    public String deleteGood(@PathVariable("id") int id){
        System.out.println(id);
        int i = goodTypeDao.deleteGoodType(id);
        String str = i > 0?"success":"error";
        return str;
    }

    @PutMapping("/goodType")
    public String updateGood(@RequestBody GoodType goodType){
        System.out.println(goodType);
        int i = goodTypeDao.updateGoodType(goodType);
        String str = i > 0?"success":"error";
        return str;
    }
}
