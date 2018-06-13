package com.tw.nho30.trainer.dao;

import com.tw.nho30.trainer.model.User;

public interface UserDao {
    User insert(User user);
    User findByEmail(String email);
}
