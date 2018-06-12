package com.tw.nho30.trainer.controller;

import com.tw.nho30.trainer.vo.Result;
import com.tw.nho30.trainer.vo.TrainerClamSummaryList;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerClamController {

    @ApiOperation(tags = "训练营", value = "获取训练营列表信息", httpMethod = "GET", notes = "获取训练营列表信息")
    @GetMapping("/trainer")
    public Result<TrainerClamSummaryList> test(){
        TrainerClamSummaryList list = new TrainerClamSummaryList();
        //TODO
        Result<TrainerClamSummaryList> result = new Result<>();
        result.setData(list);
        return result;
    }
}
