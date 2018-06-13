package com.tw.nho30.trainer.service;

import com.tw.nho30.trainer.model.TrainerClam;
import com.tw.nho30.trainer.vo.TrainerClamSummary;

import java.util.List;

public interface TrainerClamSummaryService {

    List<TrainerClamSummary> queryAllList();

    TrainerClam getByTrainerClamId(String trainerClamId);
}
