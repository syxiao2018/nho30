package com.tw.nho30.trainer.controller;

import com.tw.nho30.trainer.model.User;
import com.tw.nho30.trainer.req.UserReq;
import com.tw.nho30.trainer.service.UserService;
import com.tw.nho30.trainer.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userSevice;

    public UserController(UserService userService){
        this.userSevice = userService;
    }

    @ApiOperation(tags = "用户", value = "用户注册", httpMethod = "POST", notes = "用户注册")
    @PostMapping("/register")
    public Result<User> register(@RequestBody UserReq user){
        return new Result<>("SUCCESS", "", new User());
    }

    @ApiOperation(tags = "用户", value = "用户登陆", httpMethod = "POST", notes = "用户登陆")
    @PostMapping("/login")
    public Result<User> login(@RequestBody UserReq user){
        return new Result<>("SUCCESS", "", new User());
    }
}
