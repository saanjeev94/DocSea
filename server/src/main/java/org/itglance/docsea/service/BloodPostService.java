package org.itglance.docsea.service;

import org.itglance.docsea.domain.BloodPost;
import org.itglance.docsea.domain.Contact;
import org.itglance.docsea.repository.BloodPostRepository;
import org.itglance.docsea.repository.ContactRepository;
import org.itglance.docsea.service.dto.BloodPostDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sanjib on 6/12/17.
 */
@Service
@Transactional
public class BloodPostService {

    private final BloodPostRepository bloodPostRepository;
    private final ContactRepository contactRepository;

    public BloodPostService(BloodPostRepository bloodPostRepository, ContactRepository contactRepository) throws ParseException {
        this.bloodPostRepository = bloodPostRepository;
        this.contactRepository = contactRepository;
    }


    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
    Date d = dateFormatter.parse(dateFormatter.format(new Date() ));

    public Page<BloodPost> getAllBlood(Pageable pageable) throws ParseException {
        Page<BloodPost> bloodPosts = bloodPostRepository.findValideBlood(d, pageable);
       /* List<BloodPostDTO> bloodPostDTOS = new ArrayList<>();

        for(BloodPost b: bloodPosts){

            if(b.getDeadline().after(d) || b.getDeadline().equals(d))
                bloodPostDTOS.add(new BloodPostDTO(b));
        }
        System.out.println(bloodPostDTOS.toString());*/
        System.out.println(bloodPosts.toString());
        return bloodPosts;
    }

    public void postBlood(BloodPostDTO bloodPostDTO) {
        BloodPost bloodPost = new BloodPost();
        bloodPost.setBloodGroup(bloodPostDTO.getBloodGroup());
        bloodPost.setDeadline(bloodPostDTO.getDeadline());
        bloodPost.setPost(bloodPostDTO.getPost());
        bloodPost.setPostDate(d);
        bloodPost.setDeadline(bloodPostDTO.getDeadline());

        Contact contact = new Contact();
        contact.setWebsite(bloodPostDTO.getContact().getWebsite());
        contact.setContactNumber1(bloodPostDTO.getContact().getContactNumber1());
        contact.setContactNumber2(bloodPostDTO.getContact().getContactNumber2());
        contact.setEmailId(bloodPostDTO.getContact().getEmailId());
        contact.setFax(bloodPostDTO.getContact().getFax());

        contactRepository.save(contact);
        bloodPost.setContact(contact);
        bloodPostRepository.save(bloodPost);


    }
}
