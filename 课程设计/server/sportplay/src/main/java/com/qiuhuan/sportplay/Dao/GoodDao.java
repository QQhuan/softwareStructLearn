package com.qiuhuan.sportplay.Dao;

import com.qiuhuan.sportplay.bean.Good;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodDao {
    //获取所有的商品,
    public List<Good> getAllGood(@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    //商品总数
    public int getGoodCount();
    //新增商品
    public int addNewGood(Good good);
    //删除商品
    public int deleteGood(int id);
    //更新商品
    public int updateGood(Good good);
    //为商品添加图片
    public int addImg(int id, String path);
}
