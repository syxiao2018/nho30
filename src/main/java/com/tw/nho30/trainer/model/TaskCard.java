package com.tw.nho30.trainer.model;

import lombok.Data;

@Data
public class TaskCard {

    private String id;

    private String name;

    private String description;

    private int status;

    private int score;

    private String trainerClamId;
}
