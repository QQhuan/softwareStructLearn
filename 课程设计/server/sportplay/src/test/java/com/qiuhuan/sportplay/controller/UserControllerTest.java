package com.qiuhuan.sportplay.controller; 


import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/** 
* UserController Tester. 
* 
* @author <Authors name> 
* @since <pre>6�� 24, 2020</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ActiveProfiles("test")

@Profile("test")
@Configuration
public class UserControllerTest { 
UserController u = new UserController();
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;
@Before
public void before() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getUserList(QueryInfo queryInfo) 
* 
*/ 
@Test
public void testGetUserList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateUserState(@RequestParam("id") Integer  id, @RequestParam("state") Boolean state) 
* 
*/ 
@Test
public void testUpdateUserState() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addUser(@RequestBody User user) 
* 
*/ 
@Test
public void testAddUser() throws Exception {
}

/** 
* 
* Method: getUpdateUser(int id) 
* 
*/ 
@Test
public void testGetUpdateUser() throws Exception { 
//TODO: Test goes here...
    mockMvc.perform(
            MockMvcRequestBuilders.get("/getUpdateUser")
                    .param("id", "1")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print());
} 

/** 
* 
* Method: editUser(@RequestBody User user) 
* 
*/ 
@Test
public void testEditUser() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteUser(int id) 
* 
*/ 
@Test
public void testDeleteUser() throws Exception { 
//TODO: Test goes here... 
} 


} 
