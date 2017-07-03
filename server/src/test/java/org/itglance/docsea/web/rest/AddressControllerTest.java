package org.itglance.docsea.web.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by sanjib on 6/14/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class AddressControllerTest {
    @Autowired
    private WebApplicationContext ctx;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

//    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }



    @Test
    public void getAddresses() throws Exception {
        System.out.println("***********************");
        mockMvc.perform(get("/api/addresses").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getCountries() throws Exception {
        System.out.println("***********************");
        mockMvc.perform(get("/api/addresses/countries").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getZones() throws Exception {
        System.out.println("***********************");
        mockMvc.perform(get("/api/addresses/zones").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getDistricts() throws Exception {
        System.out.println("***********************");
        mockMvc.perform(get("/api/addresses/districts").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getCities() throws Exception {
        System.out.println("***********************");
        mockMvc.perform(get("/api/addresses/cities").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getZonesFromCountry() throws Exception {
        System.out.println("***********************");
        String country = "Nepal";
        mockMvc.perform(get("/api/addresses/zones/{country}", country).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getDistrictsFromZone() throws Exception {
        System.out.println("***********************");
        String zone = "Bagmati";
        mockMvc.perform(get("/api/addresses/districts/{zone}", zone).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void getCitiesFromDistrict() throws Exception {
        System.out.println("***********************");
        String city = "Kathmandu";
        mockMvc.perform(get("/api/addresses/cities/{district}", city).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

}