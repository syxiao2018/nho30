package com.tw.nho30.trainer.controller;

import com.tw.nho30.trainer.vo.TrainerResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerClamController {

    @ApiOperation(tags = "训练营", value = "获取训练营列表信息", httpMethod = "GET", notes = "获取训练营列表信息")
    @GetMapping("/trainer")
    public TrainerResponse test(){
        return new TrainerResponse();
    }
}
