package com.tw.nho30.trainer.vo;

import com.tw.nho30.trainer.model.TaskCard;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(value = "trainerClamDetail", description = "训练营详情")
public class TrainerClamDetailVO {

    /**
     * 唯一标示
     */
    private String id;

    /**
     * 名字
     */
    private String name;

    /**
     * summary
     */
    private String summary;

    /**
     * 开课时间
     */
    private String startDate;

    /**
     * 报名人数
     */
    private int inNum;

    private List<TaskCardVO> taskCards;

    @Data
    public static class TaskCardVO {

        private String id;

        private String name;

        private String description;

        private int status;

        private int score;

    }
}


