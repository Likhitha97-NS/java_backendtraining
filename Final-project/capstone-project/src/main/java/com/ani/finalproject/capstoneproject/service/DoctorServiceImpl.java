package com.ani.finalproject.capstoneproject.service;

import com.ani.finalproject.capstoneproject.domain.DoctorInfo;
import com.ani.finalproject.capstoneproject.dto.DoctorDto;
import com.ani.finalproject.capstoneproject.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository repository;

    @Override
    public DoctorDto createDoctor(DoctorDto dto){
        var doctor=new DoctorInfo();
        doctor.setId(dto.getId());
        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setHospitalNm(dto.getHospitalNm());
        doctor.setLocality(dto.getLocality());
        doctor.setVisiting(dto.getVisiting());
        return dto;
    }
}
