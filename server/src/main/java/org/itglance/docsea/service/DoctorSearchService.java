package org.itglance.docsea.service;

import org.itglance.docsea.domain.*;
import org.itglance.docsea.repository.*;
import org.itglance.docsea.service.dto.HospitalDoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sriyanka on 5/25/2017.
 */

@Service
@Transactional
public class DoctorSearchService {

    private final HospitalDoctorRepository hospitalDoctorRepository;
    private final HospitalRepository hospitalRepository;
    private final DoctorRepository doctorRepository;
    private final CountryRepository countryRepository;
    private final ZoneRepository zoneRepository;
    private final DistrictRepository districtRepository;
    private final CityRepository cityRepository;
    private final SpecialityRepository specialityRepository;

    @Autowired
    SessionService sessionService;
    @Autowired
    StatusService statusService;

    public DoctorSearchService(HospitalDoctorRepository hospitalDoctorRepository, HospitalRepository hospitalRepository
                            , DoctorRepository doctorRepository, CountryRepository countryRepository, ZoneRepository zoneRepository
            , DistrictRepository districtRepository, CityRepository cityRepository, SpecialityRepository specialityRepository) {
        this.hospitalDoctorRepository = hospitalDoctorRepository;
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.countryRepository = countryRepository;
        this.zoneRepository = zoneRepository;
        this.districtRepository = districtRepository;
        this.cityRepository = cityRepository;
        this.specialityRepository = specialityRepository;
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


    // Quick search ..........

    public List<String> getStringListForSearch(String str){
         List<String> combineResult = new ArrayList<>();
        combineResult.clear();
        List<String> hospitalResult = hospitalRepository.findThisDoctor(str);
        combineResult.addAll(hospitalResult);


        List<String> doctorResult = doctorRepository .findThisDoctor(str);
        combineResult.addAll(doctorResult);

        List<String> specialityResult = specialityRepository .findThisDoctor(str);
        combineResult.addAll(specialityResult);

        List<String> countryResult = countryRepository.findThisDoctor(str);
        combineResult.addAll(countryResult);

        List<String> zoneResult = zoneRepository.findThisDoctor(str);
        combineResult.addAll(zoneResult);

        List<String> districtResult = districtRepository.findThisDoctor(str);
        combineResult.addAll(districtResult);

        List<String> cityResult = cityRepository.findThisDoctor(str);
        combineResult.addAll(cityResult);


        System.out.println(combineResult);
        Collections.sort(combineResult);
        return combineResult;
    }
}
