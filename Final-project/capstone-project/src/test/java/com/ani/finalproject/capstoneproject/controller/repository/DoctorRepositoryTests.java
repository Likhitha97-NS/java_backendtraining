package com.ani.finalproject.capstoneproject.controller.repository;

import com.ani.finalproject.capstoneproject.domain.DoctorInfo;
import com.ani.finalproject.capstoneproject.repository.DoctorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DoctorRepositoryTests {

    @Autowired
    private DoctorRepository repository;

    @DisplayName("testing of creating doctor")
    @Test
    public void testCreateDoctor()
    {
        DoctorInfo dto= new DoctorInfo();
        dto.setId(100l);
        dto.setName("bharath");
        dto.setSpecialization("dermatologist");
        dto.setHospitalNm("rainbow");
        dto.setLocality("banglore");
        dto.setVisiting(true);

        DoctorInfo dt=repository.save(dto);
        Assertions.assertNotNull(dt);
    }
    @DisplayName("Testing delete doctor")
    @Test
    public void testDeleteDoctor() {
        repository.deleteById(10L);


    }

    @DisplayName("Testing doctor by locality")
    @Test
    public void testDoctorFindByloc(){
        var op = repository.searchBySpecialization("cardiology");
        Assertions.assertNotNull(op);
    }
}
