





基于`springboot`的web应用开发实验

[TOC]



# 实验目的

1. 学习IDEA，postman的安装
2. 学习使用springboot进行开发
3. 学习使用postman进行接口测试
4. 学习mysql数据库的使用

# 实验平台

1. 操作系统：win10，64bits，i57200
2. 编辑工具：IDEA v2019.3.4
3. 服务器：Tomcat v9.0
4. 打包工具：maven
5. 数据库：MySQL v8.0

# 实验前准备

1. 网上学习，掌握springboot框架的基础知识与使用
2. 网上学习，掌握postman的基础使用方法
3. 网上学习，掌握mysql的基础知识和使用
4. 安装必要的软件和工具（包含：mysql，navicat，vue-cli，vscode等）

# 实验内容

1. IDEA的安装

   1） 进入 IntelliJ IDEA 官网，选择 IntelliJ IDEA 点击进去；

   ![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy80NjI1NDAxLTNjZGRjYjg0MjZkN2E0YmEucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQvc3RyaXB8aW1hZ2VWaWV3Mi8yL3cvNTAwL2Zvcm1hdC93ZWJw?x-oss-process=image/format,png)

    

   2）进入 IntelliJ IDEA后会弹出以下页面，点击 Download 下载 IntelliJ IDEA；

   ![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy80NjI1NDAxLWMwODg4N2FhYmFkZmNlNzMucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQvc3RyaXB8aW1hZ2VWaWV3Mi8yL3cvNTAwL2Zvcm1hdC93ZWJw?x-oss-process=image/format,png)

    

   3）选择对应系统版本下载；官网上提供了 Windows，macOS 和 Linux 三个操作系统，每个系统都有两个版本可供下载： Ultimate 和 Community。

   ![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy80NjI1NDAxLTAwNTVhYzRjYWEwMDQxYzQucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQvc3RyaXB8aW1hZ2VWaWV3Mi8yL3cvNTAwL2Zvcm1hdC93ZWJw?x-oss-process=image/format,png)

   Ultimate 为旗舰版；功能全面，插件丰富，但是收费，按年收费；
   Community 为社区版；免费试用，功能相对而言不是很丰富，但是不影响开发使用。

   2. IntelliJ IDEA安装

   1）双击下载的可执行文件ideaIU-2018.3.3.exe，直接点击 “Next”；

   ![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy80NjI1NDAxLWQzN2JhZmI5ZjJjMGJmNjMucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQvc3RyaXB8aW1hZ2VWaWV3Mi8yL3cvNTAzL2Zvcm1hdC93ZWJw?x-oss-process=image/format,png)

    

   2）选择安装路径，直接点击 “Next”；

   ![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy80NjI1NDAxLTE5MzU0OGViMWNmZjlhYmUucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQvc3RyaXB8aW1hZ2VWaWV3Mi8yL3cvNTAzL2Zvcm1hdC93ZWJw?x-oss-process=image/format,png)

    

   3）根据系统类型选择安装 32位或着 64位，然后选择关联文件类型。点击 “Next”；

   ![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy80NjI1NDAxLWJhZDBhNTA0ZTZkMWM3YTcucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQvc3RyaXB8aW1hZ2VWaWV3Mi8yL3cvNTAzL2Zvcm1hdC93ZWJw?x-oss-process=image/format,png)

   4）选择安装插件，点击 “Install” 开始安装；

   ![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy80NjI1NDAxLTY2MTc1MDUzMDk3MGE4NzgucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQvc3RyaXB8aW1hZ2VWaWV3Mi8yL3cvNTAzL2Zvcm1hdC93ZWJw?x-oss-process=image/format,png)

    

   5）等待安装完成即可；

   

   ![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy80NjI1NDAxLTExNDlhNTAxMWY0ZjZjZWIucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQvc3RyaXB8aW1hZ2VWaWV3Mi8yL3cvNTAzL2Zvcm1hdC93ZWJw?x-oss-process=image/format,png)

   5）安装完成，点击 “Finish”；


   ![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91cGxvYWQtaW1hZ2VzLmppYW5zaHUuaW8vdXBsb2FkX2ltYWdlcy80NjI1NDAxLTQ1YWMzOTk5MzE3YTUyYjEucG5nP2ltYWdlTW9ncjIvYXV0by1vcmllbnQvc3RyaXB8aW1hZ2VWaWV3Mi8yL3cvNTAzL2Zvcm1hdC93ZWJw?x-oss-process=image/format,png)

2. postman的安装

   1. 官网下载：地址：https://www.getpostman.com/downloads/，选择页面中的“Download”，根据自己电脑配置，选择32位下载还是64位下载

   ![img](https://img2020.cnblogs.com/blog/992081/202004/992081-20200428225207869-1794688286.png)

   2. 双击下载好应用程序安装包，进行安装

   ![img](https://img2020.cnblogs.com/blog/992081/202004/992081-20200428225243753-1259544964.png)

   3. 因为Postman是免安装的，双击安装包，自动安装到本地电脑中

   ![img](https://img2020.cnblogs.com/blog/992081/202004/992081-20200428225302115-501928989.png)

   4. 安装成功，显示登录界面，注册登录账号或者登录账号

   ![img](https://img2020.cnblogs.com/blog/992081/202004/992081-20200428225336013-2137807873.png)

   5. Postman的主界面

   ![img](https://img2020.cnblogs.com/blog/992081/202004/992081-20200428225405378-1562359057.png)

3. springboot项目的搭建

   1. 第一步，创建项目，`file`>`new`>`project`>`spring initializr`

      ![image-20200627120605790](C:\Users\88\AppData\Roaming\Typora\typora-user-images\image-20200627120605790.png)

      根据需要，选择JDK的版本，我选择的是V1.8，然后`next`

   2. 第二步，完善项目基本信息，将`example`换成自己想要的目录名，`Artifact`写项目名，然后`next`

      ![image-20200627121244309](C:\Users\88\AppData\Roaming\Typora\typora-user-images\image-20200627121244309.png)

   3. 第三步，选择开发依赖，`web`>勾选`spring web，`SQL`>勾选`JDBC API`、`Mybatis Framework`、`MySQL Driver`，JDBC是java提供的数据库连接，mybatis可以提供更加便捷的数据库操作映射，最后一个driver是mysql的驱动，因为我们用的是mysql数据库，然后`next`

      ![image-20200627122130420](C:\Users\88\AppData\Roaming\Typora\typora-user-images\image-20200627122130420.png)

   4. 第四步，项目名和存储地址，然后`finish`

      ![image-20200627122341618](C:\Users\88\AppData\Roaming\Typora\typora-user-images\image-20200627122341618.png)

4. web服务的登陆实现

   1. 全局类配置允许跨域

      ```java
      package com.qiuhuan.sportplay.util;
      
      import org.springframework.context.annotation.Configuration;
      import org.springframework.web.servlet.config.annotation.CorsRegistry;
      import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
      
      @Configuration
      public class WebConfig extends WebMvcConfigurerAdapter {
      
          @Override
          public void addCorsMappings(CorsRegistry registry) {
              registry.addMapping("/**") //端口路径
                      .allowedOrigins("http://localhost:8080", "null") //允许请求源
                      .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE") //允许的方法
                      .maxAge(3600)               //请求最大时长
                      .allowCredentials(true); //写在凭证信息，例如cookie等
          }
      }
      ```

   2.  jdbc连接数据库并配置服务端口号为9000

      ```java
      # mysql
      spring:
        datasource:
          #MySQL配置
          driverClassName:  com.mysql.cj.jdbc.Driver
          url: jdbc:mysql://localhost:3306/easyproject?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
          username: root
          password: 123456
      server:
        port: 9000
      ```

   3. 登陆的dao层与mapping

      ```java
      package com.qiuhuan.sportplay.Dao;
      
      import com.qiuhuan.sportplay.bean.User;
      import org.apache.ibatis.annotations.Param;
      import org.springframework.stereotype.Repository;
      
      import java.util.List;
      
      @Repository
      public interface UserDao {
          //账号密码获取用户信息，登陆用
          public User getUserByMessage(@Param("username") String username, @Param("password") String password);
      }
      ```

      ```xml
      <?xml version="1.0" encoding="UTF-8" ?>
      <!DOCTYPE mapper  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
              "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
      <mapper namespace="com.qiuhuan.sportplay.Dao.UserDao">
          <select id="getUserByMessage" resultType="com.qiuhuan.sportplay.bean.User">
             SELECT * FROM easyUser
             WHERE username=#{username} AND password=#{password} AND state = 1
      	</select>	
      </mapper>
      ```

   4. 登陆的controller层（不再分service层，整合在controller中）

      ```java
      package com.qiuhuan.sportplay.controller;
      
      import com.alibaba.fastjson.JSON;
      import com.qiuhuan.sportplay.Dao.UserDao;
      import com.qiuhuan.sportplay.bean.User;
      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.web.bind.annotation.RequestBody;
      import org.springframework.web.bind.annotation.RequestMapping;
      import org.springframework.web.bind.annotation.RestController;
      
      import java.util.HashMap;
      
      @RestController
      public class loginController {
          @Autowired
          UserDao userDao;
      
          @RequestMapping("/login")
          public String login(@RequestBody User user){
              String flag = "error";
              User u = userDao.getUserByMessage(user.getUsername(), user.getPassword());
              HashMap<String, Object> res = new HashMap<>();
              if(u != null){
                  flag = "OK";
              }
              res.put("status", flag);  //状态码
              res.put("user", u);
              String res_json = JSON.toJSONString(res);
              return res_json;
          }
      }
      ```

   5. 启动类注解dao层扫描

      ```java
      package com.qiuhuan.sportplay;
      
      import org.mybatis.spring.annotation.MapperScan;
      import org.springframework.boot.SpringApplication;
      import org.springframework.boot.autoconfigure.SpringBootApplication;
      
      @MapperScan("com.qiuhuan.sportplay.Dao") //扫描dao层
      @SpringBootApplication
      public class userApplication {  //启动类
          public static void main(String[] args) {
              SpringApplication.run(userApplication.class, args);
          }
      }
      ```

5. postman测试登陆接口

   1. 在主界面新建`collection`

      ![image-20200627164820631](C:\Users\88\AppData\Roaming\Typora\typora-user-images\image-20200627164820631.png)

   2. 在`collection`中新建`request`

      ![image-20200627164925627](C:\Users\88\AppData\Roaming\Typora\typora-user-images\image-20200627164925627.png)

   3. 填写相应的url与参数

      ![image-20200627171343780](C:\Users\88\AppData\Roaming\Typora\typora-user-images\image-20200627171343780.png)

   4. IDEA中启动服务，postman中发送请求，结果截图

      ![image-20200627171400061](C:\Users\88\AppData\Roaming\Typora\typora-user-images\image-20200627171400061.png)

# 实验总结

1. 学习的spring，了解了MVC三层开发模式的意思。M是Model，是模型，模型持有所有的数据、状态和程序逻辑，模型独立于视图和控制器。V是View，是视图，用来呈现模型。视图通常直接从模型中取得它需要显示的状态与数据。对于相同的信息可以有多个不同的显示形式或视图。C是Controller，是控制器，位于视图和模型中间，负责接受用户的输入，将输入进行解析并反馈给模型，通常一个视图具有一个控制器。MVC模式的应用，提高开发效率。在开发界面显示部分时，你仅仅需要考虑的是如何布局一个好的用户界面；开发模型时，你仅仅要考虑的是业务逻辑和数据维护，这样能使开发者专注于某一方面的开发，提高开发效率。

2. 学习并理解了springboot框架，它是一款轻量级框架，基于Spring4.0设计，不仅继承了Spring框架原有的优秀特性，而且还通过简化配置来进一步简化了Spring应用的整个搭建和开发过程。另外SpringBoot通过集成大量的框架使得依赖包的版本冲突，以及引用的不稳定性等问题得到了很好的解决。

   在学习开发应用中，我大量使用注解，大大方便了开发，加快了实现速度。

3. 学习使用postman，掌握了对于各种参数类型的请求设置。在postman中，可以通过添加脚本到请求当中，来使用动态变量、在请求之间传递数据以及编写测试。写在`Pre-request Script`tab中的代码会在请求发送之前执行，而写在`Tests`tab中的代码会在响应到达之后执行。

   测试用的语言是JavaScript。所以对于前端开发者来说几乎没有学习成本。对于一个单独的请求来说，如果它有测试脚本，那么在请求发送之后，在`Test Results`tab可以看到对应的测试结果。

   对于前端或者后端的开发者来说，这都是一个十分搞笑便捷的测试工具。

4. mysql结合mybatis进行使用，对于复杂的嵌套的数据类型进行封装，通过写映射来返回想要的数据，不得不说本次实验，收获不少。

   对于新框架的学习与使用，更像是开阔了我的眼界，越学才会才会发现自己懂的太少，唯有不断地学习新知识、新技术才能更好的在计算机行业立足。