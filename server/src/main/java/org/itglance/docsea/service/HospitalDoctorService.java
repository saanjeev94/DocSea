package org.itglance.docsea.service;

import org.itglance.docsea.domain.*;
import org.itglance.docsea.repository.DoctorRepository;
import org.itglance.docsea.repository.HospitalDoctorRepository;
import org.itglance.docsea.repository.HospitalRepository;
import org.itglance.docsea.repository.ScheduleRepository;
import org.itglance.docsea.service.dto.DoctorDTO;
import org.itglance.docsea.service.dto.ScheduleDTO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sriyanka on 5/23/2017.
 */

@Service
@Transactional
public class HospitalDoctorService {

    public static final Logger logger = LoggerFactory.getLogger(HospitalDoctorService.class);

    private final HospitalDoctorRepository hospitalDoctorRepository;
    private final HospitalRepository hospitalRepository;
    private final DoctorRepository  doctorRepository;
    private final ScheduleRepository scheduleRepository;

    @Autowired
    StatusService statusService;

    public HospitalDoctorService(HospitalDoctorRepository hospitalDoctorRepository, HospitalRepository hospitalRepository, DoctorRepository doctorRepository, ScheduleRepository scheduleRepository) {
        this.hospitalDoctorRepository = hospitalDoctorRepository;
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public void changeHospitalDoctorStatus(Long hospitalId, Long doctorId){

        HospitalDoctor hospitalDoctor= hospitalDoctorRepository.findByHospitalDoctor(hospitalId, doctorId);
        System.out.println(hospitalDoctor.toString());

        String status1=hospitalDoctor.getStatus().getStatus();

        if(status1.equalsIgnoreCase("Active")){
            status1="Inactive";
        }
        else if(status1.equalsIgnoreCase("Inactive")){
            status1="Active";
        }


        hospitalDoctor.setStatus(statusService.getStatusObject(status1));
        hospitalDoctorRepository.save(hospitalDoctor);


    }

    public void hospitalDoctorSchedule(Long doctorId){
        long hospitalId=1;
        List<Schedule> doctorSchedules=doctorRepository.findScheduleByDoctorId(doctorId);
        List<Schedule> hospitalSchedules=hospitalRepository.findScheduleByHospitalId(hospitalId);
        List<Schedule> hospitalDoctorSchedules=new ArrayList<>();

        for(Schedule currentHospitalSchedule:hospitalSchedules){
            for(Schedule currentDoctorSchedule:doctorSchedules ){
                if(currentHospitalSchedule.getId()==currentDoctorSchedule.getId()){
                    hospitalDoctorSchedules.add(currentDoctorSchedule);
                }
            }
        }

        for(Schedule schedule:hospitalDoctorSchedules){
            logger.info(schedule.toString());
        }


    }

}
