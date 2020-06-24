package com.qiuhuan.sportplay.controller;

import com.alibaba.fastjson.JSON;
import com.qiuhuan.sportplay.Dao.UserDao;
import com.qiuhuan.sportplay.bean.QueryInfo;
import com.qiuhuan.sportplay.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;

    //获取用户列表
    @CrossOrigin
    @RequestMapping(value = "/allUser", method = RequestMethod.GET)  //注解为get方法
    public String getUserList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = userDao.getUserCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<User> users = userDao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        System.out.println("总条数："+numbers);
        String users_json = JSON.toJSONString(res);
        return users_json;
    }

    //修改用户
    @PutMapping("/userState")
    public String updateUserState(@RequestParam("id") Integer  id,
                                  @RequestParam("state") Boolean state){

        int i = userDao.updateState(id, state);
        System.out.println("用户编号:"+id);
        System.out.println("用户状态:"+state);
        String str = i >0?"success":"error";
        return str;
    }

    //添加用户
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)   //post方法
    public String addUser(@RequestBody User user){
        System.out.println(user);
        user.setRole("普通用户"); //默认操作
        user.setState(false);    //默认操作
        int i = userDao.addUser(user);
        String str = i >0?"success":"error";
        return str;
    }

    //获取单个用户
    @RequestMapping("/getUpdate")
    public String getUpdateUser(int id){
        System.out.println("编号:"+id);
        User updateUser = userDao.getUpdateUser(id);
        String users_json = JSON.toJSONString(updateUser);
        return users_json;
    }

    //编辑用户
    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        System.out.println(user);
        int i = userDao.editUser(user);
        String str = i >0?"success":"error";
        return str;
    }

    //删除用户
    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        System.out.println(id);
        int i = userDao.deleteUser(id);
        String str = i >0?"success":"error";
        return str;
    }
}
