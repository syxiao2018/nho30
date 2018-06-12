package com.tw.nho30.trainer.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserUtils {
    private static final String EMAIL_REGEX = "^\\w+((-\\w)|(\\.\\w))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

    public static boolean isPasswordValidate(String password){
        if(password == null){
            return false;
        }
        return password.length() >= 8 && password.length() <= 16;
    }

    public static boolean isEmailValidate(String email){
        if(email == null){
            return false;
        }
        return UserUtils.genMacher(EMAIL_REGEX, email).matches();
    }

    private static Matcher genMacher(String pattern, String value){
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(value);
        return matcher;
    }
}
