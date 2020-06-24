package com.qiuhuan.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.qiuhuan.sportplay.Dao.KaloryDao;
import com.qiuhuan.sportplay.bean.Kalory;
import com.qiuhuan.sportplay.bean.QueryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class KaloryController {
    @Autowired
    KaloryDao kaloryDao;

    @GetMapping("kalory")
    public String getAllKalory(QueryInfo queryInfo){
        int numbers = kaloryDao.getKaloryCount(); // 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<Kalory> kalories = kaloryDao.getAllKalory(pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data", kalories);
        System.out.println("总条数："+numbers);
        String data_json = JSON.toJSONString(res);
        return data_json;
    }
}
