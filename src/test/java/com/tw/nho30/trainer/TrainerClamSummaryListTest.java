package com.tw.nho30.trainer;

import com.tw.nho30.trainer.vo.TrainerClamSummary;
import com.tw.nho30.trainer.service.TrainerClamSummaryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainerApplication.class)
public class TrainerClamSummaryListTest {

    @Autowired
    private TrainerClamSummaryService trainerClamSummaryService;

    @Test
    public void should_return_all_clam_list() {
        List<TrainerClamSummary> clamSummaries = trainerClamSummaryService.queryAllList();
        Assert.assertNotNull(clamSummaries);
    }

}
