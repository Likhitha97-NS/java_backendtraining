package com.ani.finalproject.capstoneproject.service;

import com.ani.finalproject.capstoneproject.domain.DoctorInfo;
import com.ani.finalproject.capstoneproject.dto.DoctorDto;
import com.ani.finalproject.capstoneproject.exception.InvalidIdException;
import com.ani.finalproject.capstoneproject.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Transactional(isolation = Isolation.READ_UNCOMMITTED,
        rollbackFor = SQLException.class,
        noRollbackFor = InvalidIdException.class)
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository repository;
    private DoctorDto dtos;

    @Override
    public DoctorDto createDoctor(DoctorDto dto) {
        var doctor = new DoctorInfo();
        doctor.setId(dto.getId());
        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setHospitalNm(dto.getHospitalNm());
        doctor.setLocality(dto.getLocality());
        doctor.setVisiting(dto.getVisiting());
        repository.save(doctor);
        return dto;

    }

    @Override
    public DoctorDto updateDoctor(DoctorDto dto) {
        DoctorInfo doc = repository.findById(dto.getId()).orElse(null);
        var doctor = new DoctorInfo();
        doctor.setId(dto.getId());
        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setHospitalNm(dto.getHospitalNm());
        doctor.setLocality(dto.getLocality());
        doctor.setVisiting(dto.getVisiting());
        repository.save(doctor);

        return dto;

    }

    @Override
    public void deleteDoctor(Long id) {
        repository.deleteById(id);

    }

    @Override
    public List<DoctorDto> searchBySpecialization(String specialization) {
        List<DoctorInfo> docs = repository.searchBySpecialization(specialization);
        List<DoctorDto> dtos = new ArrayList<>();

        for (int i = 0; i < docs.size(); i++) {
            DoctorInfo docinfo = docs.get(i);
            var dto1 = new DoctorDto(
                    docinfo.getId(),
                    docinfo.getName(),
                    docinfo.getSpecialization(),
                    docinfo.getHospitalNm(),
                    docinfo.getLocality(),
                    docinfo.getVisiting()
            );

            dtos.add(dto1);
        }
        return dtos;
    }

    @Override
    public Long countByLocalityAndSpecialization(String specialization, String locality) {
        Long count = 0L;
        List<DoctorInfo> doc = repository.findAll();
        for (int i = 0; i < doc.size(); i++) {
            DoctorInfo doctor = doc.get(i);
            if (doctor.getSpecialization().equals(specialization) &&
                    doctor.getLocality().equals(locality))
                count++;
        }
        return count;
    }
}

