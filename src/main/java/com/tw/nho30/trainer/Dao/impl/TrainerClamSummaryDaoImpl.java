package com.tw.nho30.trainer.Dao.impl;

import com.tw.nho30.trainer.Dao.TrainerClamSummaryDao;
import com.tw.nho30.trainer.manage.TrainerClamManager;
import com.tw.nho30.trainer.model.TrainerClam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class TrainerClamSummaryDaoImpl implements TrainerClamSummaryDao {
    @Autowired
    private TrainerClamManager trainerClamManager;

    @Override
    public Set<TrainerClam> queryAll() {
        Set<TrainerClam> data = trainerClamManager.getTrainerClams();
        return data;
    }
}
