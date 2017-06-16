package org.itglance.docsea.service;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.itglance.docsea.domain.*;
import org.itglance.docsea.repository.ContactRepository;
import org.itglance.docsea.repository.DoctorRepository;
import org.itglance.docsea.repository.HospitalDoctorRepository;
import org.itglance.docsea.service.dto.ContactDTO;
import org.itglance.docsea.service.dto.DoctorDTO;
import org.itglance.docsea.service.dto.QualificationDTO;
import org.itglance.docsea.service.dto.SpecialityDTO;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by sanj__000 on 6/7/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class DoctorServiceTest {

    @Autowired
    DoctorService doctorService;

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    HospitalDoctorRepository hospitalDoctorRepository;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    SessionService sessionService;

    Doctor doctor=new Doctor();
    Doctor doctor1=new Doctor();
    Speciality speciality = new Speciality();
    Contact contact = new Contact();
    Qualification qualification = new Qualification();
    Long hospitalId;


    @Before
    public void before(){
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

        hospitalId = sessionService.checkSession("c059f96c-c18f-44c0-8814-b913ddb11f46").getHospitalId();
        doctorService.addDoctor(new DoctorDTO(doctor), "c059f96c-c18f-44c0-8814-b913ddb11f46");
        doctor1 = doctorRepository.findByNmcNumber(doctor.getNmcNumber());



    }
    @After
    public void after(){
        HospitalDoctor hospitalDoctor = hospitalDoctorRepository.findByDoctor(doctor1);
        hospitalDoctorRepository.delete(hospitalDoctor);
        doctorRepository.delete(doctor1);
        contactRepository.delete(doctor1.getContact());
    }



    @Test
    public void addDoctor() throws Exception {
        Assert.assertEquals(doctor.getNmcNumber(),doctor1.getNmcNumber());
    }

    @Test
    public void isDoctorExist() throws Exception {
        System.out.println("******************");
        System.out.println(doctorService.isDoctorExist(new DoctorDTO(doctor),hospitalId));
        System.out.println(new DoctorDTO(doctor));
        System.out.println(hospitalId);
        System.out.println("******************");
        System.out.println("******************");
        Assert.assertTrue(doctorService.isDoctorExist(new DoctorDTO(doctor),hospitalId));
    }

    @Test
    public void isDoctorExist1() throws Exception {
        Assert.assertTrue(doctorService.isDoctorExist(doctor1.getId()));
    }

    @Test
    public void updateDoctor() throws Exception {
        doctor = doctorRepository.findByNmcNumber(doctor.getNmcNumber());
        doctor.setName("Ranjana maharjan");
        doctorService.updateDoctor(new DoctorDTO(doctor));
        doctor1 = doctorRepository.findByNmcNumber(doctor.getNmcNumber());
        Assert.assertEquals(doctor.getName(),doctor1.getName());
    }

    @Test
    public void renamePhoto() throws Exception {
        File file = new File("C:\\Users\\sanj__000\\Desktop\\Capture.jpg");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file",
                file.getName(), "text/plain", IOUtils.toByteArray(input));
        Assert.assertNotNull(doctorService.renamePhoto(multipartFile));
    }

    @Test
    public void validateNmcforUpdate() throws Exception {
        Assert.assertTrue(doctorService.validateNmcforUpdate(new DoctorDTO(doctor1)));
    }
}