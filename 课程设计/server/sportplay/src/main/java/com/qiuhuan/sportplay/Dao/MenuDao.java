package com.qiuhuan.sportplay.Dao;

import com.qiuhuan.sportplay.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    //获得功能菜单
    public List<MainMenu> getMenus();
}
