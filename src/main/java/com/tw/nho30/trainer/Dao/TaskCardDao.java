package com.tw.nho30.trainer.Dao;

import com.tw.nho30.trainer.model.TaskCard;

import java.util.List;

public interface TaskCardDao {

    List<TaskCard> getByTrainerClamId(String trainerClamId);
}
