package org.itglance.docsea.service;

import org.itglance.docsea.domain.HospitalDoctor;
import org.itglance.docsea.repository.HospitalDoctorRepository;
import org.itglance.docsea.service.dto.HospitalDoctorDTO;
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

    public DoctorSearchService(HospitalDoctorRepository hospitalDoctorRepository) {
        this.hospitalDoctorRepository = hospitalDoctorRepository;
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
}
