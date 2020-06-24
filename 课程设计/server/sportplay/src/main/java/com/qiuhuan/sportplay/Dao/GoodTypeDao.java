package com.qiuhuan.sportplay.Dao;

import com.qiuhuan.sportplay.bean.Good;
import com.qiuhuan.sportplay.bean.GoodType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodTypeDao {
    //获取所有分类
    public List<GoodType> getAllGoodType(@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    //商品总数
    public int getGoodTypeCount();
    //新增商品分类
    public int addNewGoodType(GoodType goodType);
    //删除商品分类
    public int deleteGoodType(int id);
    //更新商品分类，仅类名
    public int updateGoodType(GoodType goodType);
}