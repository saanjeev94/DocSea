package org.itglance.docsea.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sriyanka on 5/8/2017.
 */

@Entity
public class Speciality {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
