package org.itglance.docsea.service;

import org.itglance.docsea.domain.*;
import org.itglance.docsea.repository.*;
import org.itglance.docsea.service.dto.HospitalDTO;
import org.itglance.docsea.service.dto.RoleDTO;
import org.itglance.docsea.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by sanj__000 on 5/10/2017.
 */
@Service
@Transactional
public class HospitalService {

    private final Logger log = LoggerFactory.getLogger(HospitalService.class);

    private final HospitalRepository hospitalRepository;

    private final HospitalUserRepository hospitalUserRepository;

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    private final CityRepository cityRepository;

    private final StatusRepository statusRepository;

    private final ContactRepository contactRepository;

    @Autowired
    private final RoleService roleService;

    @Autowired
    private final StatusService statusService;


    public HospitalService(HospitalRepository hospitalRepository,
                           StatusRepository statusRepository,RoleService roleService, HospitalUserRepository hospitalUserRepository
                            , UserRepository userRepository, AddressRepository addressRepository, CityRepository cityRepository
                            , ContactRepository contactRepository, StatusService statusService) {
        this.hospitalRepository = hospitalRepository;
        this.statusRepository = statusRepository;
        this.roleService = roleService;
        this.hospitalUserRepository = hospitalUserRepository;
        this.userRepository = userRepository;
        this.cityRepository = cityRepository;
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
        this.statusService = statusService;
    }

    public void registerHospital(HospitalDTO hospitalDTO, UserDTO userDTO){
        Hospital hospital = new Hospital();
        HospitalUser hospitalUser = new HospitalUser();
        User user = new User();
        Status status = new Status();

        Role role = null;
        Address address = new Address();
        Contact contact = new Contact();

        hospital.setLisenceNo(hospitalDTO.getLisenceNo());
        hospital.setName(hospitalDTO.getName());
        hospital.setRegistrationNo(hospitalDTO.getRegistrationNo());

        contact.setContactNumber1(hospitalDTO.getContact().getContactNumber1());
        contact.setContactNumber2(hospitalDTO.getContact().getContactNumber2());
        contact.setEmailId(hospitalDTO.getContact().getEmailId());
        contact.setFax(hospitalDTO.getContact().getFax());
        contact.setWebsite(hospitalDTO.getContact().getWebsite());
        contactRepository.save(contact);
        hospital.setContact(contact);


        address.setStreetAddress(hospitalDTO.getAddress().getStreetAddress());
        address.setCity(cityRepository.findByName( hospitalDTO.getAddress().getCity().getName() ) );
        address.setDistrict(cityRepository.findByName(hospitalDTO.getAddress().getCity().getName()).getDistrict());
        address.setZone(cityRepository.findByName(hospitalDTO.getAddress().getCity().getName()).getDistrict().getZone());
        address.setCountry(cityRepository.findByName(hospitalDTO.getAddress().getCity().getName()).getDistrict().getZone().getCountry());
        addressRepository.save(address);
        hospital.setAddress(address);
        hospitalRepository.save(hospital);

        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());

        status = statusService.getStatusObject("INACTIVE");
        user.setStatus(status);

        role = roleService.getRoleObject("HOSPITAL");
        user.getRoles().add(role);


        userRepository.save(user);


        hospitalUser.setHospitall(hospital);
        hospitalUser.setUser(user);

        log.info(hospitalDTO.getName()+" has been registered into system");

        hospitalUserRepository.save(hospitalUser);

    }

    public boolean isHospitalExist(HospitalDTO hospitalDTO, UserDTO userDTO){
        HospitalDTO hospitalDTOTemp;
        UserDTO userDTOTemp;
        userDTOTemp = userRepository.findByUsername(userDTO.getUsername());
        hospitalDTOTemp = hospitalRepository.findByhospitalNameRegLisence(hospitalDTO.getName(),
                hospitalDTO.getRegistrationNo(),hospitalDTO.getLisenceNo());
        if(hospitalDTOTemp != null || userDTOTemp != null){
            return true;
        }

        return false;
    }

}
