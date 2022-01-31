package com.ani.finalproject.capstoneproject.controller;

import com.ani.finalproject.capstoneproject.domain.DoctorInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DoctorControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testGetMethod()
    {
        String url="http://" + "localhost" + ":" + port + "/doctor";
        DoctorInfo doc=template.getForObject(url,DoctorInfo.class);
        Assertions.assertNotNull(doc);
    }
}
