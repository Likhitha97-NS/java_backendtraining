package com.ani.finalproject.capstoneproject.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DoctorInfoTests {
    @DisplayName("checking : Doctor correctness")
    @Test
    void testObjectCreation(){
        var doctor=new DoctorInfo();
        Assertions.assertNotNull(doctor);
    }

    @DisplayName("Domain : checking getters and setters")
    @Test
    void testObjectGettersSetters(){
        var doctor=new DoctorInfo();
        doctor.setId(10L);
        doctor.setName("hello");
        doctor.setSpecialization("cardiology");
        doctor.setHospitalNm("Apollo");
        doctor.setLocality("Manglore");
        doctor.setVisiting(true);

        Assertions.assertEquals(10L,doctor.getId());
        Assertions.assertEquals("hello",doctor.getName());
        Assertions.assertEquals("cardiology",doctor.getSpecialization());
        Assertions.assertEquals("Apollo",doctor.getHospitalNm());
        Assertions.assertEquals("Manglore",doctor.getLocality());
        Assertions.assertEquals(true,doctor.getVisiting());

    }
}
