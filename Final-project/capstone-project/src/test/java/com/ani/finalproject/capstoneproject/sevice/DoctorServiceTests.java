package com.ani.finalproject.capstoneproject.sevice;

import com.ani.finalproject.capstoneproject.domain.DoctorInfo;
import com.ani.finalproject.capstoneproject.service.DoctorServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DoctorServiceTests {

    @Autowired
    private DoctorServiceImpl service; // I want to create fake behaviour, I can use mocking

    @DisplayName("Service : Doctor Not Null")
    @Test
    public void testDoctorSave() {

        DoctorInfo doctor = new DoctorInfo();
        doctor.setName("abcd");
        doctor.setSpecialization("Opthamology");
        doctor.setLocality("tumkur");

    }

    @DisplayName("Service : Car Equality")
    @Test
    public void testDoctorEquality() {
        DoctorInfo doctor = new DoctorInfo();
        doctor.setName("abcd");
        doctor.setSpecialization("Opthamology");
        doctor.setLocality("tumkur");
    }
}
