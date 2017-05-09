package org.itglance.docsea.service.dto;

/**
 * Created by sriyanka on 5/8/2017.
 */
public class Speciality {
    private Long id;
    private String name;

    public Speciality(){

    }

    public Speciality(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Speciality(Speciality speciality){
        this.id=speciality.id;
        this.name=speciality.name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
