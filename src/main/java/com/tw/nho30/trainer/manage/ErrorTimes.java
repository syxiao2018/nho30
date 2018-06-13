package com.tw.nho30.trainer.manage;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorTimes {
    private int userId;
    private int times;
    private long time;
}
