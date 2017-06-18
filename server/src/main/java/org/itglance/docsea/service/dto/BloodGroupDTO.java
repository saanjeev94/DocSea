package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.BloodGroup;

/**
 * Created by sanjib on 6/18/17.
 */
public class BloodGroupDTO {

    private Long id;

    private String bloodGroup;

    private String image;

    public BloodGroupDTO() {
    }

    public BloodGroupDTO(Long id, String bloodGroup, String image) {
        this.id = id;
        this.bloodGroup = bloodGroup;
        this.image = image;
    }

    public BloodGroupDTO(BloodGroup bloodGroup) {
        this(bloodGroup.getId(),bloodGroup.getBloodGroup(),bloodGroup.getImage());
    }
}
