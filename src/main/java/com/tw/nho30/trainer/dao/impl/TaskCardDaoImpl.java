package com.tw.nho30.trainer.dao.impl;

import com.tw.nho30.trainer.dao.TaskCardDao;
import com.tw.nho30.trainer.model.TaskCard;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskCardDaoImpl implements TaskCardDao {

    private static List<TaskCard> allTaskCards =  new ArrayList<>();

    static {

        TaskCard task11 = new TaskCard();
        task11.setId("task11");
        task11.setName("10以内的加减法");
        task11.setDescription("适合1年级学生练习");
        task11.setStatus(0);
        task11.setScore(-1);
        task11.setTrainerClamId("1");
        allTaskCards.add(task11);

        TaskCard task12 = new TaskCard();
        task12.setId("task12");
        task12.setName("10以内的乘除法");
        task12.setDescription("适合1年级学生练习");
        task12.setStatus(0);
        task12.setScore(-1);
        task12.setTrainerClamId("1");
        allTaskCards.add(task12);


        TaskCard task22 = new TaskCard();
        task22.setId("task22");
        task22.setName("一般过去式练习");
        task22.setDescription("适合7年级学生练习");
        task22.setStatus(1);
        task22.setScore(80);
        task22.setTrainerClamId("2");
        allTaskCards.add(task22);
    }

    public List<TaskCard> getByTrainerClamId(String trainerClamId){

        return allTaskCards.stream().
                filter(x -> x.getTrainerClamId().equals(trainerClamId))
                .collect(Collectors.toList());
    }
}
