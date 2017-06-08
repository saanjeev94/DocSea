package org.itglance.docsea.service;

import org.itglance.docsea.domain.Days;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by sanj__000 on 6/7/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DayServiceTest {
    @Autowired
    DayService dayService;

    Days day =new Days();
    @Test
    public void getDayObject() throws Exception {
        day = dayService.getDayObject("Sunday");
        Assert.assertNotNull("Day Id should not be null", day.getId());
    }

}