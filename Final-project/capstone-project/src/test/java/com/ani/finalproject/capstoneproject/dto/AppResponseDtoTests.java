package com.ani.finalproject.capstoneproject.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppResponseDtoTests {

    @DisplayName(" checking for correctness of appresponse")
    @Test
    void testAppResponse(){
        var app=new AppResponse<String>();
        app.setStatus("success");
        app.setMessage("doctor created successfully");
        app.setBody("t");

        Assertions.assertEquals("success",app.getStatus());
        Assertions.assertEquals("doctor created successfully",app.getMessage());
        Assertions.assertEquals("t",app.getBody());
    }
}
