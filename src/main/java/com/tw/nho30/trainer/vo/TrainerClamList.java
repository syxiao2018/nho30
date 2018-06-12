package com.tw.nho30.trainer.vo;

import com.tw.nho30.trainer.model.TrainerClam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(value = "trainer", description = "训练营")
public class TrainerClamList {
    @ApiModelProperty(notes = "训练营列表")
    private List<TrainerClam> clams;
}
