package com.qiuhuan.sportplay.Dao;

import com.qiuhuan.sportplay.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMenus();
}
