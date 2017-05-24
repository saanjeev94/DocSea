package org.itglance.docsea.service;

import org.itglance.docsea.domain.Status;
import org.itglance.docsea.repository.StatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by soni on 5/8/2017.
 */
@Service
@Transactional
public class StatusService {

    private final Logger log = LoggerFactory.getLogger(RoleService.class);
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public void addStatus(String statusStr){
        Status status = new Status();
        status.setStatus(statusStr);
        statusRepository.save(status);
        log.info("New Status "+statusStr+" has been inserted into Status table");

    }

    public Status getStatusObject(String statusStr)
    {
        Status status= new Status();
        List<Status> statusList= statusRepository.findAll();
        if(!statusList.isEmpty()){
            for(Status s : statusList){
                if(s.getStatus().equalsIgnoreCase(statusStr)){
                    return s;
                }
            }
        }
        addStatus(statusStr);
        status = statusRepository.findByStatus(statusStr);
        return status;
    }

//    public boolean changeStatus(String status){
//        if(!)
//    }
}
