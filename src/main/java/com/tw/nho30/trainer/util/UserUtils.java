package com.tw.nho30.trainer.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserUtils {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^\\w+((-\\w)|(\\.\\w))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?![A-Z]+$)(?![a-z]+$)(?!\\d+$)(?![\\W_]+$)\\S{8,16}$");

    public static boolean isPasswordValidate(String password){
        if(password == null){
            return false;
        }
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static boolean isEmailValidate(String email){
        if(email == null){
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
