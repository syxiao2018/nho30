package com.tw.nho30.trainer.manage;

import com.tw.nho30.trainer.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {

    private static Map<Integer, User> userMap = new ConcurrentHashMap<>(16);
    private static int globalId = 1;

    public static User insert(User user){
        assert(user.getId() == null);
        user.setId(UserManager.generateUserId());
        userMap.put(user.getId(), user);
        return user;
    }

    public static User findByEmail(String email){
        for(Map.Entry<Integer, User> entry: userMap.entrySet()) {
            if(entry.getValue().getEmail().equals(email)){
                return entry.getValue();
            }
        }
        return null;
    }

    private static synchronized int generateUserId(){
        return globalId++;
    }
}
