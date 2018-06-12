package com.tw.nho30.trainer.Dao.impl;

import com.tw.nho30.trainer.Dao.UserDao;
import com.tw.nho30.trainer.manage.UserManager;
import com.tw.nho30.trainer.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User insert(User user) {
        return UserManager.insert(user);
    }

    @Override
    public User findByEmail(String email) {
        return UserManager.findByEmail(email);
    }
}
