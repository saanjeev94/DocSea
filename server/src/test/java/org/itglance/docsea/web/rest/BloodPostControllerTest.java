package org.itglance.docsea.web.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.itglance.docsea.domain.BloodPost;
import org.itglance.docsea.domain.Contact;
import org.itglance.docsea.repository.BloodPostRepository;
import org.itglance.docsea.repository.ContactRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by sanjib on 6/15/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BloodPostControllerTest {


    @Autowired
    private WebApplicationContext ctx;


    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    BloodPost bloodPost=new BloodPost();
    Contact contact = new Contact();

    @Before
    public void setUp() throws Exception {
            this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void postBlood() throws Exception {

        contact.setEmailId("sldkf@yahoo.com");
        contact.setContactNumber1("TEST");
        contact.setContactNumber2("123");

        bloodPost.setContact(contact);
        bloodPost.setDeadline(new Date("2017/12/12"));
        bloodPost.setPost("emergency blood need");
        bloodPost.setBloodGroup("TEST");

        System.out.println("***********************");
        mockMvc.perform(post("/api/bloodPost").accept(MediaType.APPLICATION_JSON)
                .content(this.json(bloodPost))
                .contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

    }

    @Test
    public void getBloodPOst() throws Exception {
        System.out.println("***********************");
        mockMvc.perform(get("/api/bloodPost?page=0&size=5").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    /*protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }*/
    public static byte[] json(Object object) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }


}