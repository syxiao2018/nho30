package com.tw.nho30.trainer.vo.voconverter;

import com.tw.nho30.trainer.model.TaskCard;
import com.tw.nho30.trainer.model.TrainerClam;
import com.tw.nho30.trainer.vo.TrainerClamDetailVO;

import java.util.stream.Collectors;

public class TrainerClamDetailConverter {

    public static TrainerClamDetailVO from(TrainerClam source) {

        TrainerClamDetailVO vo = new TrainerClamDetailVO();
        vo.setId(source.getId());
        vo.setInNum(source.getInNum());
        vo.setName(source.getName());
        vo.setStartDate(source.getStartDate());
        vo.setSummary(source.getSummary());
        vo.setTaskCards(source.getTaskCards().stream().map(TrainerClamDetailConverter::from).collect(Collectors.toList()));

        return vo;
    }

    public static TrainerClamDetailVO.TaskCardVO from(TaskCard source){

        TrainerClamDetailVO.TaskCardVO vo = new TrainerClamDetailVO.TaskCardVO();
        vo.setId(source.getId());
        vo.setDescription(source.getDescription());
        vo.setName(source.getName());
        vo.setScore(source.getScore());
        vo.setStatus(source.getStatus());

        return vo;
    }
}
