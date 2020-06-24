package com.qiuhuan.sportplay.Dao;

import com.qiuhuan.sportplay.bean.Kalory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KaloryDao {
    //获取所有卡路里记录
    public List<Kalory> getAllKalory(@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    //总数
    public int getKaloryCount();
}
