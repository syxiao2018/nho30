package com.tw.nho30.trainer.model;

import lombok.Data;


import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrainerClam {
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

    private List<TaskCard> taskCards;

    public TrainerClam(String id, String name, String summary, String startDate, int inNum) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.startDate = startDate;
        this.inNum = inNum;
    }

    @Override
    public int hashCode() {
        return 31 * id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj instanceof TrainerClam) {
            TrainerClam other = (TrainerClam) obj;
            return other.id.equals(this.id);
        }
        return super.equals(obj);
    }
}
