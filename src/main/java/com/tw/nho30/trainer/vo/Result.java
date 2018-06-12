package com.tw.nho30.trainer.vo;

import lombok.Data;

@Data
public class Result<T> {
    private String status;
    private String message = "";
    private T data;
}
