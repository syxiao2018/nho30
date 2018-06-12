package com.tw.nho30.trainer.service.impl;

import com.tw.nho30.trainer.Dao.TrainerClamSummaryDao;
import com.tw.nho30.trainer.model.TrainerClam;
import com.tw.nho30.trainer.service.TrainerClamSummaryService;
import com.tw.nho30.trainer.vo.TrainerClamSummary;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TrainerClamSummaryServiceImpl implements TrainerClamSummaryService {
    @Autowired
    private TrainerClamSummaryDao trainerClamSummaryDao;

    @Override
    public List<TrainerClamSummary> queryAllList() {
        Set<TrainerClam> trainerClamsSet = trainerClamSummaryDao.queryAll();
        List<TrainerClamSummary> result = new ArrayList<>();
        //转为vo
        trainerClamsSet.forEach(summary -> {
            TrainerClamSummary vo = new TrainerClamSummary();
            BeanUtils.copyProperties(summary, vo);
            result.add(vo);
        });
        return result;
    }
}
