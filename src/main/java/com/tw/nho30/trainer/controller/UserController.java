package com.tw.nho30.trainer.controller;

import com.tw.nho30.trainer.aop.constant.Status;
import com.tw.nho30.trainer.manage.SessionManager;
import com.tw.nho30.trainer.model.User;
import com.tw.nho30.trainer.req.UserReq;
import com.tw.nho30.trainer.service.UserService;
import com.tw.nho30.trainer.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userSevice;

    @Autowired
    public UserController(UserService userService){
        this.userSevice = userService;
    }

    @ApiOperation(tags = "用户", value = "用户注册", httpMethod = "POST", notes = "用户注册")
    @PostMapping("/register")
    public Result<User> register(@RequestBody UserReq userReq){
        User user = userSevice.register(userReq);
        return new Result<>(Status.OK, "", user);
    }

    @ApiOperation(tags = "用户", value = "用户登陆", httpMethod = "POST", notes = "用户登陆")
    @PostMapping("/login")
    public Result<User> login(@RequestBody UserReq userReq, HttpServletRequest request){
        User user = userSevice.login(userReq);
        SessionManager.invalidateAnoterUser(user.getId());
        request.setAttribute("user", user);
        SessionManager.addSession(request.getSession());
        return new Result<>(Status.OK, "", user);
    }

    @ApiOperation(tags = "用户", value = "用户注销", httpMethod = "POST", notes = "用户注销")
    @PostMapping("/logout")
    public Result<User> logout(HttpServletRequest request){
        request.getSession().invalidate();
        return new Result<>(Status.OK, "", null);
    }


}
