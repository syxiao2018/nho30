package com.tw.nho30.trainer.vo;

import com.tw.nho30.trainer.aop.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Status status;
    private String message = "";
    private T data;
}
