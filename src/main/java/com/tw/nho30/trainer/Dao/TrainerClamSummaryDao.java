package com.tw.nho30.trainer.Dao;

import com.tw.nho30.trainer.vo.TrainerClamSummary;

import java.util.List;

public interface TrainerClamSummaryDao {
    /**
     * 查询所有的训练营
     * @return
     */
    List<TrainerClamSummary> queryAll();
}
