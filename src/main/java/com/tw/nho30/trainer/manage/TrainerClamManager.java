package com.tw.nho30.trainer.manage;

import com.tw.nho30.trainer.model.TrainerClam;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TrainerClamManager {
    private Set<TrainerClam> trainerClams = new HashSet<>();

    public TrainerClamManager(){
        initTrainData();
    }

    public Set<TrainerClam> getTrainerClams() {
        return trainerClams;
    }

    /**
     * 初始化mock训练营数据
     */
    private void initTrainData() {
        TrainerClam t1 = new TrainerClam("1",
                "体育爱好者",
                "爱好篮球、乒乓球等运动的同学欢迎参与",
                "2018-06-12",
                12);
        trainerClams.add(t1);

        TrainerClam t2 = new TrainerClam("2",
                "音乐爱好者",
                "爱好流行、民谣等曲风的同学欢迎参与",
                "2018-06-31",
                31);
        trainerClams.add(t2);

        TrainerClam t3 = new TrainerClam("3",
                "天文爱好者",
                "爱好观象的同学欢迎参与",
                "2018-06-22",
                22);
        trainerClams.add(t3);

        TrainerClam t4 = new TrainerClam("4",
                "农业爱好者",
                "爱好插秧、种田的同学欢迎参与",
                "2018-08-12",
                2);
        trainerClams.add(t4);

        TrainerClam t5 = new TrainerClam("5",
                "中药爱好者",
                "爱好采药、行医的同学欢迎参与",
                "2018-11-02",
                8);
        trainerClams.add(t5);
    }

}
