package com.tw.nho30.trainer.controller;

import com.tw.nho30.trainer.service.TrainerClamSummaryService;
import com.tw.nho30.trainer.vo.Result;
import com.tw.nho30.trainer.vo.TrainerClamSummary;
import com.tw.nho30.trainer.vo.TrainerClamSummaryList;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainerClamController {
    @Autowired
    private TrainerClamSummaryService trainerClamSummaryService;

    @ApiOperation(tags = "trainer", value = "获取训练营列表信息", httpMethod = "GET", notes = "获取训练营列表信息")
    @GetMapping("/trainer")
    public Result<TrainerClamSummaryList> test(){
        List<TrainerClamSummary> trainerClamSummaries = trainerClamSummaryService.queryAllList();
        TrainerClamSummaryList result = new TrainerClamSummaryList();
        result.setClams(trainerClamSummaries);
        return new Result<>(Status.OK, null, result);
    }

    @ApiOperation(tags = "训练营详细", value = "获取训练营详细信息", httpMethod = "GET", notes = "获取训练营列表详细信息")
    @GetMapping("trainer/{trainerClamId}")
    public Result<TrainerClamDetailVO> trainerClamDetail(@PathVariable("trainerClamId") String trainerClamId) {

        if (Strings.isNullOrEmpty(trainerClamId)) {
            throw new IllegalRequestArgumentException();
        }

        TrainerClam trainerClam = trainerClamSummaryService.getByTrainerClamId(trainerClamId);

        return new Result<>("ok", null, TrainerClamDetailConverter.from(trainerClam));

    }
}
