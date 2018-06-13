package com.tw.nho30.trainer.manage;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LockManager {
    private static final Map<Integer, ErrorTimes> ERROR_TIMES = new ConcurrentHashMap<>();
    private static final int ERROR_SPACE = 3600 * 1000;

    public static boolean isLocked(Integer userId){
        ErrorTimes times = ERROR_TIMES.get(userId);
        if(times == null){
            return false;
        }
        if(System.currentTimeMillis() - times.getTime() > ERROR_SPACE){
            ERROR_TIMES.remove(userId);
            return false;
        }
        return times.getTimes() >= 5;
    }

    public static synchronized void addLock(int userId){
        ErrorTimes times = ERROR_TIMES.get(userId);
        times = verifyAndCreateErrorTimes(times);
        times.setTimes(times.getTimes() + 1);
        times.setUserId(userId);
        ERROR_TIMES.put(userId, times);
    }

    public static ErrorTimes verifyAndCreateErrorTimes(ErrorTimes times){
        if(times == null || (System.currentTimeMillis() - times.getTime() > ERROR_SPACE)){
            return createErrorTimes();
        }
        return times;
    }

    private static ErrorTimes createErrorTimes(){
        ErrorTimes times = new ErrorTimes();
        times.setTime(System.currentTimeMillis());
        return times;
    }
}
