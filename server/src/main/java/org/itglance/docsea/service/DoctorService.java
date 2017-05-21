package org.itglance.docsea.service;

;
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












}
