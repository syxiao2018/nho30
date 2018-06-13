package com.tw.nho30.trainer.service.impl;

import com.tw.nho30.trainer.dao.TaskCardDao;
import com.tw.nho30.trainer.dao.TrainerClamSummaryDao;
import com.tw.nho30.trainer.model.TaskCard;
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

    @Autowired
    private TaskCardDao taskCardDao;

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

    @Override
    public TrainerClam getByTrainerClamId(String trainerClamId){

        TrainerClam trainerClam = trainerClamSummaryDao.getById(trainerClamId);
        this.attachTaskCards(trainerClam);

        return trainerClam;
    }

    private void attachTaskCards(TrainerClam trainerClam) {

        List<TaskCard> taskCards = taskCardDao.getByTrainerClamId(trainerClam.getId());
        trainerClam.setTaskCards(taskCards);
    }
}
