package com.tw.nho30.trainer.dao;

import com.tw.nho30.trainer.model.TrainerClam;

import java.util.Set;

public interface TrainerClamSummaryDao {

    Set<TrainerClam> queryAll();

    TrainerClam getById(String id);
}
