package com.tw.nho30.trainer.service;

import com.tw.nho30.trainer.Dao.UserDao;
import com.tw.nho30.trainer.model.User;
import com.tw.nho30.trainer.req.UserReq;
import org.springframework.stereotype.Service;

public interface UserService {
    User register(UserReq userReq);
    User login(UserReq userReq);
}
