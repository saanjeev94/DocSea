package org.itglance.docsea.service;

import org.itglance.docsea.service.dto.AddressDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

/**
 * Created by sanj__000 on 6/7/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressServiceTest {
    @Autowired
    AddressService addressService;

    List<AddressDTO> addressDTOS = new ArrayList<>();
    List<String> listOfString = new ArrayList<>();

    @Before
    public void before() {
        addressDTOS = null;
        listOfString = null;
    }
    @Test
    public void getAllAddresses() throws Exception {
        addressDTOS = addressService.getAllAddresses();
        Assert.assertNotNull("Expected not null", addressDTOS);
    }


    @Test
    public void getAllZones() throws Exception {
        listOfString = addressService.getAllZones();
        Assert.assertNotNull("Expected not null", listOfString);
    }

    @Test
    public void getAllDistricts() throws Exception {
        listOfString = addressService.getAllDistricts();
        Assert.assertNotNull("Expected not null", listOfString);
    }

    @Test
    public void getAllCities() throws Exception {
        listOfString = addressService.getAllCities();
        Assert.assertNotNull("Expected not null", listOfString);
    }

    @Test
    public void getZonesFromCountry() throws Exception {
        listOfString = addressService.getZonesFromCountry("Nepal");
        Assert.assertNotNull("Expected not null", listOfString);
    }

    @Test
    public void getDistrictFromZone() throws Exception {
        listOfString = addressService.getDistrictFromZone("Bagmati");
        Assert.assertNotNull("Expected not null", listOfString);
    }

    @Test
    public void getCitiesFromDistrict() throws Exception {
        listOfString = addressService.getCitiesFromDistrict("Kathmandu");
        Assert.assertNotNull("Expected not null", listOfString);
    }


    @Test
    public void getAllCountries() throws Exception {
        listOfString = addressService.getAllCountries();
        Assert.assertNotNull("Expected not null", listOfString);
    }

}