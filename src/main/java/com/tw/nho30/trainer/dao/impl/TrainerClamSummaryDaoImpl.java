package com.tw.nho30.trainer.dao.impl;

import com.tw.nho30.trainer.dao.TrainerClamSummaryDao;
import com.tw.nho30.trainer.manage.TrainerClamManager;
import com.tw.nho30.trainer.model.TrainerClam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class TrainerClamSummaryDaoImpl implements TrainerClamSummaryDao {
    @Autowired
    private TrainerClamManager trainerClamManager;

    @Override
    public Set<TrainerClam> queryAll() {
        return trainerClamManager.getTrainerClams();
    }

    @Override
    public TrainerClam getById(String id) {

        List<TrainerClam> rets = trainerClamManager.getTrainerClams()
                .stream()
                .filter(x -> x.getId().equals(id))
                .collect(Collectors.toList());

        if (rets.size() > 1) {
            throw new IllegalStateException("duplicate trainer clam with same id.");
        }

        if (rets.size() == 0) {
            return null;
        }

        return rets.get(0);
    }
}
