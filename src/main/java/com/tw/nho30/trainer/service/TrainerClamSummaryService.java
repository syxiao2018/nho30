package com.tw.nho30.trainer.service;

import com.tw.nho30.trainer.vo.TrainerClamSummary;

import java.util.List;

public interface TrainerClamSummaryService {
    /**
     * 查询所有的训练营列表集合
     * @return
     */
    List<TrainerClamSummary> queryAllList();
}
