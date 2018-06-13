package com.tw.nho30.trainer.service.impl;

import com.tw.nho30.trainer.dao.UserDao;
import com.tw.nho30.trainer.exception.LoginFailException;
import com.tw.nho30.trainer.exception.ValidationException;
import com.tw.nho30.trainer.model.User;
import com.tw.nho30.trainer.req.UserReq;
import com.tw.nho30.trainer.service.UserService;
import com.tw.nho30.trainer.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public User register(UserReq userReq) {
        this.validateEmail(userReq);
        this.validatePassword(userReq);
        User user = new User();
        user.setEmail(userReq.getEmail());
        user.setPassword(userReq.getPassword());
        return userDao.insert(user);
    }

    @Override
    public User login(UserReq userReq) {
        User user = userDao.findByEmail(userReq.getEmail());
        if(user == null || !user.getPassword().equals(userReq.getPassword())){
            throw new LoginFailException("账号或密码错误");
        }
        return user;
    }

    private void validateEmail(UserReq userReq){
        if(!UserUtils.isEmailValidate(userReq.getEmail())){
            throw new ValidationException("邮箱格式不正确");
        }
        if(userDao.findByEmail(userReq.getEmail()) != null){
            throw new ValidationException("邮箱已经注册");
        }
    }

    private void validatePassword(UserReq userReq){
        if(!UserUtils.isPasswordValidate(userReq.getPassword())){
            throw new ValidationException("密码格式不正确，密码必须包含字母，数字，特殊符号中的两种，长度8-16");
        }
    }
}
