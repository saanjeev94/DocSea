package org.itglance.docsea.service;

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
public class DoctorSearchServiceTest {
    @Autowired
    DoctorSearchService doctorSearchService;

    @Test
    public void findDoctor() throws Exception {
        Assert.assertNotNull("list should not be null",doctorSearchService.findDoctor("sanjeev"));
    }

    @Test
    public void findAllDoctorsOfHospital() throws Exception {
        Assert.assertNotNull("list should not be null", doctorSearchService.findAllDoctorsOfHospital("c059f96c-c18f-44c0-8814-b913ddb11f46"));
    }

    @Test
    public void getStringListForSearch() throws Exception {
        Assert.assertNotNull("list should not be null","sanjeev");
    }

}