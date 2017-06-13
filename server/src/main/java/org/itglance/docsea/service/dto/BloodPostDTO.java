package org.itglance.docsea.service.dto;

import org.itglance.docsea.domain.BloodPost;
import org.itglance.docsea.domain.Contact;

import java.util.Date;

/**
 * Created by sanjib on 6/12/17.
 */
public class BloodPostDTO {

    private Long id;

    private String post;

    private String bloodGroup;

    private Date deadline;

    private Date postDate;

    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public BloodPostDTO() {
    }

    public BloodPostDTO(Long id, String post, String bloodGroup, Date deadline, Date postDate, Contact contact) {
        this.id = id;
        this.post = post;
        this.bloodGroup = bloodGroup;
        this.deadline = deadline;
        this.postDate = postDate;
        this.contact = contact;
    }

    public BloodPostDTO(BloodPost bloodPost){
        this(bloodPost.getId(),bloodPost.getPost(), bloodPost.getBloodGroup(), bloodPost.getDeadline(), bloodPost.getPostDate(), bloodPost.getContact());
    }

    public Long getId() {
        return id;
    }

    public String getPost() {
        return post;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Date getPostDate() {
        return postDate;
    }



    @Override
    public String toString() {
        return "BloodPostDTO{" +
                "id=" + id +
                ", post='" + post + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", deadline=" + deadline +
                ", postDate=" + postDate +
                '}';
    }
}
