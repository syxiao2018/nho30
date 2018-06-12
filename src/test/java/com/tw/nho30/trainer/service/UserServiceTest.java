package com.tw.nho30.trainer.service;

import com.tw.nho30.trainer.model.User;
import com.tw.nho30.trainer.req.UserReq;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void before(){
        UserReq user = new UserReq();
        user.setEmail("test@mail.com");
        user.setPassword("password123");
        userService.register(user);
    }

    @Test
    public void test_register_success(){
        UserReq userReq = new UserReq();
        userReq.setEmail("test1@mail.com");
        userReq.setPassword("password123");
        User user = userService.register(userReq);
        Assert.assertTrue(2 == user.getId());
    }

    @Test
    public void test_login_success(){
        UserReq userReq = new UserReq();
        userReq.setEmail("test@mail.com");
        userReq.setPassword("password123");
        User user = userService.login(userReq);
        Assert.assertTrue(1 == user.getId());
    }
}
