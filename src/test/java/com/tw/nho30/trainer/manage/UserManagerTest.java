package com.tw.nho30.trainer.manage;

import com.tw.nho30.trainer.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserManagerTest {

    @Before
    public void before(){
        User user = new User();
        user.setEmail("xxx@mail.com");
        user.setPassword("password123");
        UserManager.insert(user);
    }

    @Test
    public void test_insert(){
        User user = new User();
        user.setEmail("xxx2ß@mail.com");
        user.setPassword("password123");
        UserManager.insert(user);
        Assert.assertTrue(2 == user.getId());
    }

    @Test
    public void test_findByEmail(){
        User user = UserManager.findByEmail("xxx@mail.com");
        Assert.assertTrue(1 == user.getId());
    }
}
