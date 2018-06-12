package com.tw.nho30.trainer.vo;

import lombok.Data;

@Data
public class Result {
    private String status;
    private String message = "";
    private Object data;
}
