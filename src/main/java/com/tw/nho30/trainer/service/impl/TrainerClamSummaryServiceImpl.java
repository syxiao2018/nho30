package com.tw.nho30.trainer.service.impl;

import com.tw.nho30.trainer.Dao.TrainerClamSummaryDao;
import com.tw.nho30.trainer.vo.TrainerClamSummary;
import com.tw.nho30.trainer.service.TrainerClamSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerClamSummaryServiceImpl implements TrainerClamSummaryService {
    @Autowired
    private TrainerClamSummaryDao trainerClamSummaryDao;

    @Override
    public List<TrainerClamSummary> queryAllList() {
        return trainerClamSummaryDao.queryAll();
    }
}
