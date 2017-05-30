package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.Qualification;

/**
 * Created by soni on 5/30/2017.
 */
public class QualificationDTO {

    private Long id;
    private String qualification;

    public QualificationDTO() {
    }

    public QualificationDTO(Long id, String qualification) {
        this.id = id;
        this.qualification = qualification;
    }

    public QualificationDTO(Qualification qualification){
        this(qualification.getId(),qualification.getQualification());
    }

    public Long getId() {
        return id;
    }

    public String getQualification() {
        return qualification;
    }
}
