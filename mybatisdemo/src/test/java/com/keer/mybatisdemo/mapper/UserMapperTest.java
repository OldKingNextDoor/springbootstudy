package com.keer.mybatisdemo.mapper;

import com.keer.mybatisdemo.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.mybatisdemo.mapper
 * @Author: keer
 * @CreateTime: 2020-03-08 11:21
 * @Description:
 */
@RunWith(SpringRunner.class)
@DisplayName("用户接口测试")
@EnableAutoConfiguration
@SpringBootTest
@Transactional
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    @DisplayName("获取全部用户信息")
    public void testGetAllUser() {
        System.out.println(userMapper.getAll().toString());
    }


    @Test
    @DisplayName("增加用户信息")
    public void testAddUserInfo() {
        User user = new User("keer", "男", "2");
        Assert.assertEquals(1, userMapper.addUserInfo(user));

    }

    @Test
    @DisplayName("根据用户id获取用户信息")
    public void testGetUserInfoByID() {
        User user = new User("keer", "男", "2");
        Assert.assertEquals(1, userMapper.addUserInfo(user));
        Assert.assertEquals("keer", userMapper.getUserInfoByID("2").getName());
    }

    @Test
    @DisplayName("根据用户id更新用户姓名")
    public void testUpdateUserNameByID() {
        User user = new User("keer", "男", "2");
        Assert.assertEquals(1, userMapper.addUserInfo(user));
        Assert.assertEquals(1, userMapper.updateUserNameByID("可耳", "2"));
    }

    @Test
    @DisplayName("根据用户id删除用户信息")
    public void testDeleteUserInfoByID() {
        User user = new User("keer", "男", "2");
        Assert.assertEquals(1, userMapper.addUserInfo(user));
        Assert.assertEquals(1, userMapper.deleteUserInfoByID("2"));
    }
}
