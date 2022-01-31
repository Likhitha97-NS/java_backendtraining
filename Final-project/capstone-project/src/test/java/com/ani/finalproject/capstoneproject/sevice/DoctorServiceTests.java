package com.ani.finalproject.capstoneproject.sevice;

import com.ani.finalproject.capstoneproject.domain.DoctorInfo;
import com.ani.finalproject.capstoneproject.service.DoctorService;
import com.ani.finalproject.capstoneproject.service.DoctorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DoctorServiceTests {
    @Autowired
    private DoctorService service;

    @DisplayName("Testing doctor by specialization :")
    @Test
    public void testDoctorFindBySpec(){
        var op = service.searchBySpecialization("opthamalogy");
        Assertions.assertNotNull(op);
    }

    @DisplayName("Testing  Doctor by locality")
    @Test
    public void testDoctorFindByloc() {
        var op = service.countByLocalityAndSpecialization("opthamalogy", "banglore");
        Assertions.assertNotNull(op);
    }


}
