package org.itglance.docsea.service;

import org.itglance.docsea.domain.*;
import org.itglance.docsea.repository.HospitalDoctorRepository;
import org.itglance.docsea.repository.HospitalRepository;
import org.itglance.docsea.service.dto.HospitalDoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sriyanka on 5/25/2017.
 */

@Service
@Transactional
public class DoctorSearchService {

    private final HospitalDoctorRepository hospitalDoctorRepository;
    private final HospitalRepository hospitalRepository;
    @Autowired
    SessionService sessionService;
    @Autowired
    StatusService statusService;

    public DoctorSearchService(HospitalDoctorRepository hospitalDoctorRepository, HospitalRepository hospitalRepository) {
        this.hospitalDoctorRepository = hospitalDoctorRepository;
        this.hospitalRepository = hospitalRepository;
    }


    public List<HospitalDoctorDTO> findDoctor(String searchString){
        List<HospitalDoctor> hospitalDoctors=hospitalDoctorRepository.findDoctorByString(searchString);
        if(hospitalDoctors==null){
            return null;
        }

        List<HospitalDoctorDTO> hospitalDoctorDTO=new ArrayList<>();
        for(HospitalDoctor d : hospitalDoctors)
        {
            hospitalDoctorDTO.add(new HospitalDoctorDTO(d));
        }

//        for(DoctorDTO doctorDTO1:doctorDTO){
//            System.out.println(doctorDTO1.toString());
//        }
        return hospitalDoctorDTO;
    }

    public List<Doctor> findAllDoctorsOfHospital(String token) {
        Session session = sessionService.checkSession(token);
        Hospital hospital = hospitalRepository.findOne(session.getHospitalId());
        Status status = statusService.getStatusObject("DEACTIVE");
        List<Doctor> doctors = hospitalDoctorRepository.findAllByHospital(hospital, status);
        return doctors;
    }
}
