package org.itglance.docsea.service;

import org.apache.commons.io.FilenameUtils;
import org.itglance.docsea.domain.Contact;
import org.itglance.docsea.domain.Doctor;
import org.itglance.docsea.domain.Speciality;
import org.itglance.docsea.repository.ContactRepository;
import org.itglance.docsea.repository.DoctorRepository;
import org.itglance.docsea.repository.ScheduleRepository;
import org.itglance.docsea.repository.SpecialityRepository;
import org.itglance.docsea.service.dto.DoctorDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;


/**
 * Created by sriyanka on 5/20/2017.
 */

@Service
@Transactional
public class DoctorService {
    private final DoctorRepository doctorRepository ;
    private final SpecialityRepository specialityRepository;
    private final ContactRepository contactRepository;
    private final ScheduleRepository scheduleRepository;


    public DoctorService(DoctorRepository doctorRepository, SpecialityRepository specialityRepository, ContactRepository contactRepository, ScheduleRepository scheduleRepository) {
        this.doctorRepository = doctorRepository;
        this.specialityRepository = specialityRepository;
        this.contactRepository = contactRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public void addDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();

        doctor.setNmcNumber(doctorDTO.getNmcNumber());
        doctor.setName(doctorDTO.getName());
        doctor.setQualification(doctorDTO.getQualification());
        doctor.setPhoto(doctorDTO.getPhoto());
        doctor.setGender(doctorDTO.getGender());

        Speciality speciality=new Speciality() ;
        speciality=specialityRepository.findByName(doctorDTO.getSpeciality().getName());
        doctor.setSpeciality(speciality);


        Contact contact = new Contact();
        contact.setContactNumber1(doctorDTO.getContact().getContactNumber1());
        contact.setContactNumber2(doctorDTO.getContact().getContactNumber2());
        contact.setEmailId(doctorDTO.getContact().getEmailId());
        contact.setWebsite(doctorDTO.getContact().getWebsite());
        contact.setFax(doctorDTO.getContact().getFax());
        contactRepository.save(contact);
        doctor.setContact(contact);

        doctor.setDetails(doctorDTO.getDetails());

        doctorRepository.save(doctor);
    }

    public boolean isDoctorExist(DoctorDTO doctorDTO){
        Doctor doctor=new Doctor();
        doctor=doctorRepository.findByNmcNumber(doctorDTO.getNmcNumber());

        if(doctor!=null){
            return true;
        }
        else{
            return false;
        }
    }


    public void updateDoctor(DoctorDTO doctorDTO){


        System.out.println("update doctor" +doctorDTO.toString());
        Doctor doctor = doctorRepository.getOne(doctorDTO.getId());
        doctor.setName(doctorDTO.getName());
        doctor.setQualification(doctorDTO.getQualification());
        doctor.setPhoto(doctorDTO.getPhoto());
        doctor.setGender(doctorDTO.getGender());
        Speciality speciality=new Speciality() ;
        speciality=specialityRepository.findByName(doctorDTO.getSpeciality().getName());
        doctor.setSpeciality(speciality);
        System.out.println("contact id " +doctorDTO.getContact().getId());
        doctor.getContact().setContactNumber1(doctorDTO.getContact().getContactNumber1());
        doctor.getContact().setContactNumber2(doctorDTO.getContact().getContactNumber2());
        doctor.getContact().setEmailId(doctorDTO.getContact().getEmailId());
        doctor.getContact().setWebsite(doctorDTO.getContact().getWebsite());
        doctor.getContact().setFax(doctorDTO.getContact().getFax());
        doctorRepository.save(doctor);

    }

    public String renamePhoto(MultipartFile file) {
        final String UPLOADED_FOLDER = "D:\\mahesh\\workspace\\docsea\\client\\src\\assets\\images\\";
        int random = (int) (Math.random() * 50000 + 1);
        String fileName = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(fileName);
//        int i = fileName.lastIndexOf('.');
//        if (i > 0) {
//            extension = fileName.substring(i + 1);
//        }
        System.out.println(extension);
        String newFileName = "doctor-" + random + "." + extension;
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + newFileName);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }
}
