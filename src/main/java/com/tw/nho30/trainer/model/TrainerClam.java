package com.tw.nho30.trainer.model;

import lombok.Data;

import java.util.List;

@Data
public class TrainerClam {
    private String id;

    private String name;

    private String description;

    private int inNum;

    private List<TaskCard> taskCards;
}
