package com.tw.nho30.trainer.vo;

import com.tw.nho30.trainer.model.TaskCard;
import com.tw.nho30.trainer.model.TrainerClam;
import com.tw.nho30.trainer.vo.converter.TrainerClamDetailConverter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TrainerClamDetailConverterTest {

    @Test
    public void test_TrainerClam_2_TrainerClamDetailVO() {

        TrainerClam t1 = new TrainerClam("1",
                "体育爱好者",
                "爱好篮球、乒乓球等运动的同学欢迎参与",
                "2018-06-12",
                12);

        TaskCard task11 = new TaskCard();
        task11.setId("task11");
        task11.setName("10以内的加减法");
        task11.setDescription("适合1年级学生练习");
        task11.setStatus(0);
        task11.setScore(-1);
        task11.setTrainerClamId("1");

        t1.setTaskCards(Arrays.asList(task11));

        TrainerClamDetailVO actual = TrainerClamDetailConverter.from(t1);

        Assert.assertEquals(t1.getId(), actual.getId());
        Assert.assertEquals(t1.getInNum(), actual.getInNum());
        Assert.assertEquals(t1.getName(), actual.getName());
        Assert.assertEquals(t1.getStartDate(), actual.getStartDate());
        Assert.assertEquals(t1.getSummary(), actual.getSummary());

        List<TrainerClamDetailVO.TaskCardVO> taskCards = actual.getTaskCards();
        Assert.assertEquals(1, taskCards.size());
        TrainerClamDetailVO.TaskCardVO taskCardVO = taskCards.get(0);
        Assert.assertEquals(task11.getId(), taskCardVO.getId());
        Assert.assertEquals(task11.getName(), taskCardVO.getName());
        Assert.assertEquals(task11.getDescription(), taskCardVO.getDescription());
        Assert.assertEquals(task11.getStatus(), taskCardVO.getStatus());
        Assert.assertEquals(task11.getScore(), taskCardVO.getScore());
    }
}
