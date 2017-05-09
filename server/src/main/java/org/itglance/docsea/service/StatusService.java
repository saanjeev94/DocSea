package org.itglance.docsea.service;

import org.itglance.docsea.repository.StatusRepository;

/**
 * Created by soni on 5/8/2017.
 */
public class StatusService {

    private StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

}
