package com.tw.nho30.trainer.manage;

import com.tw.nho30.trainer.model.User;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {
    private static Map<String, HttpSession> SESSION_MAP = new ConcurrentHashMap<>(64);

    public static void addSession(HttpSession session){
        SESSION_MAP.put(session.getId(), session);
    }

    public static void removeSession(HttpSession session){
        SESSION_MAP.remove(session.getId());
    }

    public static void invalidateAnoterUser(int userId){
        Iterator<Map.Entry<String, HttpSession>> entries = SESSION_MAP.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, HttpSession> entry = entries.next();
            HttpSession session = entry.getValue();
            User user = (User)session.getAttribute("user");
            if(user == null){
                continue;
            }
            session.invalidate();
        }
    }
}
