package org.itglance.docsea.service;

import org.itglance.docsea.domain.Hospital;
import org.itglance.docsea.repository.HospitalRepository;
import org.itglance.docsea.service.dto.HospitalDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by sanj__000 on 5/10/2017.
 */
@Service
@Transactional
public class HospitalService {

    private final Logger log = LoggerFactory.getLogger(HospitalService.class);
    private final HospitalRepository hospitalRepository;
    private HospitalService hospitalService;


    public HospitalService(HospitalRepository hospitalRepository,HospitalService hospitalService ) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalService = hospitalService;
    }

    public void saveHospital(HospitalDTO hospitalDTO){
        Hospital hospital = null;
        if(!isHospitalExist(hospitalDTO)){
            hospital.setAddress(hospitalDTO.getAddress());
            hospital.setContact(hospitalDTO.getContact());
            hospital.set
        }
    }

    public boolean isHospitalExist(HospitalDTO hospitalDTO){
        HospitalDTO hospitalDTOTemp;
        hospitalDTOTemp = hospitalRepository.findByRegistrationNo(hospitalDTO.getRegistrationNo());
        if(hospitalDTOTemp != null){
            return true;
        }

        return false;
    }
}
