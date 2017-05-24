package org.itglance.docsea.service;

;
import org.itglance.docsea.domain.*;
import org.itglance.docsea.repository.*;
import org.itglance.docsea.service.dto.DoctorDTO;
import org.itglance.docsea.service.dto.ScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
    private final HospitalDoctorRepository hospitalDoctorRepository;
    private final HospitalRepository hospitalRepository;
    @Autowired
    ScheduleService scheduleService;


    public DoctorService(DoctorRepository doctorRepository, SpecialityRepository specialityRepository, ContactRepository contactRepository, ScheduleRepository scheduleRepository, HospitalDoctorRepository hospitalDoctorRepository, HospitalRepository hospitalRepository) {
        this.doctorRepository = doctorRepository;
        this.specialityRepository = specialityRepository;
        this.contactRepository = contactRepository;
        this.scheduleRepository = scheduleRepository;
        this.hospitalDoctorRepository = hospitalDoctorRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public void addDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();

        doctor.setNmcNumber(doctorDTO.getNmcNumber());
        doctor.setName(doctorDTO.getName());
        doctor.setQualification(doctorDTO.getQualification());
        doctor.setPhoto(doctorDTO.getPhoto());
        doctor.setGender(doctorDTO.getGender());

        Speciality speciality= specialityRepository.findByName(doctorDTO.getSpeciality().getName());
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

            Doctor doctor = doctorRepository.getOne(doctorDTO.getId());



            System.out.println("update doctor" +doctorDTO.toString());


            //doctor.setNmcNumber(doctorDTO.getNmcNumber());
//            doctor.setId(doctorDTO.getId());
            doctor.setName(doctorDTO.getName());
            doctor.setQualification(doctorDTO.getQualification());
            doctor.setPhoto(doctorDTO.getPhoto());
            doctor.setGender(doctorDTO.getGender());
            Speciality speciality=new Speciality() ;
            speciality=specialityRepository.findByName(doctorDTO.getSpeciality().getName());
            doctor.setSpeciality(speciality);


//            Contact contact = new Contact();
            System.out.println("contact id " +doctorDTO.getContact().getId());
//            doctor.getContact().setId(doctorDTO.getContact().getId());
            doctor.getContact().setContactNumber1(doctorDTO.getContact().getContactNumber1());
            doctor.getContact().setContactNumber2(doctorDTO.getContact().getContactNumber2());
            doctor.getContact().setEmailId(doctorDTO.getContact().getEmailId());
            doctor.getContact().setWebsite(doctorDTO.getContact().getWebsite());
            doctor.getContact().setFax(doctorDTO.getContact().getFax());
//            doctor.setContact(contact);

            //doctor.setDetails(doctorDTO.getDetails());
            //System.out.println(doctor.toString());

            doctorRepository.save(doctor);







        }

        public void linkSchedule(Long id,ScheduleDTO scheduleDTO, List<Schedule> schedule){
            Doctor doctor=doctorRepository.getOne(id);
//            System.out.println(scheduleDTO.toString());
//            System.out.println( scheduleService.getScheduleId(scheduleDTO));
            schedule.add(scheduleRepository.findById(scheduleService.getScheduleId(scheduleDTO)));
            doctor.setSchedules(schedule);
            doctorRepository.save(doctor);
        }














}
