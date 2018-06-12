package com.tw.nho30.trainer.Dao;

import com.tw.nho30.trainer.model.TrainerClam;

import java.util.Set;

public interface TrainerClamSummaryDao {
    /**
     * 查询所有的训练营
     * @return
     */
    Set<TrainerClam> queryAll();

    TrainerClam getById(String id);
}
