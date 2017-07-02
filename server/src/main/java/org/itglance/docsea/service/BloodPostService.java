package org.itglance.docsea.service;

import org.itglance.docsea.domain.BloodGroup;
import org.itglance.docsea.domain.BloodPost;
import org.itglance.docsea.domain.Contact;
import org.itglance.docsea.repository.BloodPostRepository;
import org.itglance.docsea.repository.ContactRepository;
import org.itglance.docsea.service.dto.BloodPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sanjib on 6/12/17.
 */
@Service
@Transactional
public class BloodPostService {

    @Autowired
    BloodGroupService bloodGroupService;

    private final BloodPostRepository bloodPostRepository;
    private final ContactRepository contactRepository;

    public BloodPostService(BloodPostRepository bloodPostRepository, ContactRepository contactRepository) throws ParseException {
        this.bloodPostRepository = bloodPostRepository;
        this.contactRepository = contactRepository;
    }


    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
    Date d = dateFormatter.parse(dateFormatter.format(new Date() ));

//    public Page<BloodPost> getAllBlood(Pageable pageable) throws ParseException {
//        Page<BloodPost> bloodPosts = bloodPostRepository.findValideBlood(d, pageable);
//       /* List<BloodPostDTO> bloodPostDTOS = new ArrayList<>();
//
//        for(BloodPost b: bloodPosts){
//
//            if(b.getDeadline().after(d) || b.getDeadline().equals(d))
//                bloodPostDTOS.add(new BloodPostDTO(b));
//        }
//        System.out.println(bloodPostDTOS.toString());*/
//        System.out.println(bloodPosts.toString());
//        return bloodPosts;
//    }

    public List<BloodPost> getAllBlood(){
        List<BloodPost> bloodPostDTOS=new ArrayList<>();
        List<BloodPost> bloodPosts=bloodPostRepository.findAll();
        for(BloodPost bloodPost: bloodPosts){
            if(bloodPost.getDeadline().after(d) || bloodPost.getDeadline().equals(d))
                bloodPostDTOS.add(bloodPost);
        }
        return bloodPostDTOS;
    }

    public void postBlood(BloodPostDTO bloodPostDTO) {
        BloodPost bloodPost = new BloodPost();
        bloodPost.setDeadline(bloodPostDTO.getDeadline());
        bloodPost.setPost(bloodPostDTO.getPost());
        bloodPost.setPostDate(d);
        bloodPost.setDeadline(bloodPostDTO.getDeadline());
        bloodPost.setContact(bloodPostDTO.getContact());
        bloodPost.setLocation(bloodPostDTO.getLocation());

        BloodGroup bloodGroup=new BloodGroup();
        bloodGroup = bloodGroupService.getBloodGroup(bloodPostDTO.getBloodGroup().getBloodGroup());
        bloodPost.setBloodGroup(bloodGroup);

        bloodPostRepository.save(bloodPost);


    }
}
