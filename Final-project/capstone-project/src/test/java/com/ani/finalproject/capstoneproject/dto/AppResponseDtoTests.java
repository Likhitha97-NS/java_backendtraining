package com.ani.finalproject.capstoneproject.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AppResponseDtoTests {

    @DisplayName("AppResponse Object Checking")
    @Test
    void testObjectCreation() {

        AppResponse ap = new AppResponse();
        Assertions.assertNotNull(ap);
    }


}
