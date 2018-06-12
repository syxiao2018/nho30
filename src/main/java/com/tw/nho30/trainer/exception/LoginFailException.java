package com.tw.nho30.trainer.exception;

public class LoginFailException extends RuntimeException {
    public LoginFailException(String message){
        super(message);
    }
}
