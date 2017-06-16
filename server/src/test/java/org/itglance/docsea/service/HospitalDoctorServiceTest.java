package org.itglance.docsea.service;

import org.itglance.docsea.domain.HospitalDoctor;
import org.itglance.docsea.repository.HospitalDoctorRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by sanj__000 on 6/8/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class HospitalDoctorServiceTest {
    @Autowired
    HospitalDoctorRepository hospitalDoctorRepository;
    @Autowired
    HospitalDoctorService hospitalDoctorService;

    HospitalDoctor hospitalDoctor;

    @Before
    public void before(){
        hospitalDoctor = null;
         hospitalDoctor = hospitalDoctorRepository.findOne(Long.valueOf(1));
        System.out.println("**********************");
        System.out.println(hospitalDoctor);
    }

    @Test
    public void getStatusFromHospitalAndDoctor() throws Exception {

        Assert.assertNotNull(hospitalDoctorService
                .getStatusFromHospitalAndDoctor(hospitalDoctor.getDoctor().getId()
                        , "029ff298-0bd5-45bf-ae8d-ce202bb540bb"));
    }

    @Test
    public void getHospitals() throws Exception {
        Assert.assertNotNull(hospitalDoctorService.getHospitals(hospitalDoctor.getDoctor().getId()));
    }

    @Test
    public void getDoctors() throws Exception {
        Assert.assertNotNull(hospitalDoctorService.getDoctors(hospitalDoctor.getHospital().getId()));
    }

}