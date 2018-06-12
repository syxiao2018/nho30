package com.tw.nho30.trainer.vo;

import lombok.Data;

@Data
public class TrainerClamSummary {
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
}
