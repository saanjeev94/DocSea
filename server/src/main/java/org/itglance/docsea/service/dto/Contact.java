package org.itglance.docsea.service.dto;

/**
 * Created by sriyanka on 5/8/2017.
 */
public class Contact {
    private Long id;
    private String contactNumber1;
    private String contactNumber2;
    private String emailId;
    private String website;
    private String fax;

    public Contact(){

    }

    public Contact(Long id, String contactNumber1, String contactNumber2, String emailId, String website, String fax) {
        this.id = id;
        this.contactNumber1 = contactNumber1;
        this.contactNumber2 = contactNumber2;
        this.emailId = emailId;
        this.website = website;
        this.fax = fax;
    }

    public Contact(Contact contact){
        this.id = contact.id;
        this.contactNumber1 = contact.contactNumber1;
        this.contactNumber2 = contact.contactNumber2;
        this.emailId = contact.emailId;
        this.website = contact.website;
        this.fax = contact.fax;
    }



    public Long getId() {
        return id;
    }

    public String getContactNumber1() {
        return contactNumber1;
    }

    public String getContactNumber2() {
        return contactNumber2;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getWebsite() {
        return website;
    }

    public String getFax() {
        return fax;
    }
}
