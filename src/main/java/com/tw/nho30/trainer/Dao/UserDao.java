package com.tw.nho30.trainer.Dao;

import com.tw.nho30.trainer.model.User;

public interface UserDao {
    User insert();
    User findByEmail(int id);
}
