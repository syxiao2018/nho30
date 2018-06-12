package com.tw.nho30.trainer.util;

import org.junit.Assert;
import org.junit.Test;

public class UserUtilsTest {

    @Test
    public void test_isPasswordValidate_true(){
        Assert.assertTrue(UserUtils.isPasswordValidate("passowrd124"));
    }

    @Test
    public void test_isPasswordValidate_false(){
        Assert.assertFalse(UserUtils.isPasswordValidate(""));
        Assert.assertFalse(UserUtils.isPasswordValidate("123"));
        Assert.assertFalse(UserUtils.isPasswordValidate("password123password123"));
        Assert.assertFalse(UserUtils.isPasswordValidate(null));
    }

    @Test
    public void test_isEmailValidate_true(){
        Assert.assertTrue(UserUtils.isEmailValidate("a123@mail.com"));
        Assert.assertTrue(UserUtils.isEmailValidate("a123@mail.com.cn"));
    }

    @Test
    public void test_isEmailValidate_false(){
        Assert.assertFalse(UserUtils.isEmailValidate(null));
        Assert.assertFalse(UserUtils.isEmailValidate(""));
        Assert.assertFalse(UserUtils.isEmailValidate("123"));
    }
}
