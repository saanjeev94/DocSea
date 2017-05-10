package org.itglance.docsea.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanj__000 on 5/8/2017.
 */

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String day;

  /*  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Schedule> scheduleList = new ArrayList<Schedule>();
*/

    public Long getId() {
        return id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", day='" + day + '\'' +
                '}';
    }
}
