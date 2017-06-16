package org.itglance.docsea.domain;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sanjib on 6/12/17.
 */

@Entity
public class BloodPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String post;

    private String bloodGroup;

    @Temporal(TemporalType.DATE)
    private Date deadline;

    @Temporal(TemporalType.DATE)
    private Date postDate;

    @OneToOne
    private Contact contact;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "BloodPost{" +
                "id=" + id +
                ", post='" + post + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", deadline=" + deadline +
                ", postDate=" + postDate +
                ", contact=" + contact +
                '}';
    }
}
