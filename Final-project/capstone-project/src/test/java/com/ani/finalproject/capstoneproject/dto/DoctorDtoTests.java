package com.ani.finalproject.capstoneproject.dto;

import com.ani.finalproject.capstoneproject.domain.DoctorInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DoctorDtoTests {
    @DisplayName("checking valid data in doctordto")
    @Test

    void testObjectCreation()
    {
        Long id = 30L;
        String name = "pragathi";
        String specialization = "dentist";
        String hospitalName = "KIMS";
        String hospitalLocality = "Hyderbad";
        boolean visiting = true;

        DoctorDto doc = new DoctorDto(id,name,specialization,hospitalName,hospitalLocality,visiting);

        long result = doc.getId();
        Assertions.assertEquals(id, result);

        String result2 = doc.getName();
        Assertions.assertEquals(name, result2);

        String result3 = doc.getSpecialization();
        Assertions.assertEquals(specialization, result3);

        String result4 = doc.getLocality();
        Assertions.assertEquals(hospitalLocality, result4);

        String result5 = doc.getHospitalNm();
        Assertions.assertEquals(hospitalName, result5);

        boolean result6 = doc.getVisiting();
        Assertions.assertEquals(result6, visiting);

        Assertions.assertNotNull(doc);
    }

    @DisplayName("DTO : Checking Getters")
    @Test
    void testObjectGetters() {

        var doc = new DoctorInfo();
        doc.setId(50L);
        doc.setName("kumar");
        doc.setSpecialization("dentist");
        doc.setHospitalNm("PMS");
        doc.setLocality("kolar");
        doc.setVisiting(true);

       Assertions.assertEquals(50,doc.getId());
        Assertions.assertEquals("kumar",doc.getName());
        Assertions.assertEquals("dentist",doc.getSpecialization());
       Assertions.assertEquals("PMS",doc.getHospitalNm());
       Assertions.assertEquals("kolar",doc.getLocality());
       Assertions.assertEquals(true,doc.getVisiting());

    }
    }

