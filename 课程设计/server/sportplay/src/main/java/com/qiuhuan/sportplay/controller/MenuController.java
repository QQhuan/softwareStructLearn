package com.qiuhuan.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.qiuhuan.sportplay.Dao.MenuDao;
import com.qiuhuan.sportplay.bean.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuDao menuDao;

    //获取功能菜单
    @RequestMapping("/menus")
    public String getAllMenus(){
        System.out.println("访问菜单成功");
        HashMap<String, Object> data = new HashMap<>();
        List<MainMenu> menus = menuDao.getMenus();
        data.put("menus", menus); //不管null不null都填充信息，防止前端字段undefined
        if(menus != null){
            data.put("status", 200);
        }else {
            data.put("status", 404);
        }
        String s = JSON.toJSONString(data);
        return s;
    }
}
