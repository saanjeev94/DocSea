package org.itglance.docsea.web.rest;

import org.itglance.docsea.domain.*;
import org.itglance.docsea.service.dto.DoctorDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.junit.Assert.*;

/**
 * Created by sanjib on 6/16/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DoctorControllerTest {
    @Autowired
    private WebApplicationContext ctx;


    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    Doctor doctor=new Doctor();
    Doctor doctor1=new Doctor();
    Speciality speciality = new Speciality();
    Contact contact = new Contact();
    Qualification qualification = new Qualification();
    Long hospitalId;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }


    @Test
    public void addDoctor() throws Exception {
        doctor.setNmcNumber(426);
        doctor.setName("Ranju Malakar");


        doctor.setPhoto("abc.png");
        doctor.setGender("Male");

        speciality.setName("Cardiology");
        doctor.setSpeciality(speciality);

        contact.setContactNumber1("1234567890");
        contact.setContactNumber2("1234567890");
        contact.setEmailId("sdlkfj@slkdjf.com");
        contact.setWebsite("sljsdfljsdflkj");
        contact.setFax("kdaksjd");
        doctor.setContact(contact);
        doctor.setDetails("sdfkhasdkfjlksjdf");

        qualification.setName("MD");
        doctor.setQualification(qualification);


    }

    @Test
    public void listAllDoctors() throws Exception {
    }

    @Test
    public void getDoctor() throws Exception {
    }

    @Test
    public void updateDoctor() throws Exception {
    }

}