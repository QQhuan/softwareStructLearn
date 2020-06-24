package com.qiuhuan.sportplay.Dao;

import com.qiuhuan.sportplay.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    //账号密码获取用户信息，登陆用
    public User getUserByMessage(@Param("username") String username, @Param("password") String password);
    //所有用户
    public List<User> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    //用户名相似数目
    public int getUserCounts(@Param("username") String username);
    //更新状态
    public int updateState(Integer id, Boolean state);
    //添加用户
    public int addUser(User user);
    //单个用户信息
    public User getUpdateUser(int id);
    //更新用户信息
    public int editUser(User user);
    //删除用户
    public int deleteUser(int id);
}
