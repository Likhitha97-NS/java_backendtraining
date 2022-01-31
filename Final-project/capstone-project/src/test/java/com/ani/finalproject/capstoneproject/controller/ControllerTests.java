package com.ani.finalproject.capstoneproject.controller;

import com.ani.finalproject.capstoneproject.domain.DoctorInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTests {
    @Autowired
    private TestRestTemplate template;
    @LocalServerPort
    private int port;

    @DisplayName("Testing get method")
    @Test
    public void testGetMethod(){
        String url="http://"+"localhost" + ":" + port + "/doctor";
        DoctorInfo doc=template.getForObject(url,DoctorInfo.class);
        Assertions.assertNotNull(doc);
    }

    @DisplayName("Testing post method to save and also update")
    @Test
    public void testPostMethod(){
        String url="http://" + "localhost" + ":" + port + "/doctor";
        var doctor=new DoctorInfo();
        doctor.setId(25L);
        doctor.setName("ramesh");
        doctor.setSpecialization("ENT");
        doctor.setHospitalNm("columbia");
        doctor.setLocality("hassan");
        doctor.setVisiting(true);

        var re=template.postForEntity(url,doctor,DoctorInfo.class);
        Assertions.assertEquals(HttpStatus.OK,re.getStatusCode());
        }
    }




