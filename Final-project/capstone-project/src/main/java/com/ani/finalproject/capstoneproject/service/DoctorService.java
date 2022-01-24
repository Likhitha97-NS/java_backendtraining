package com.ani.finalproject.capstoneproject.service;

import com.ani.finalproject.capstoneproject.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    public DoctorDto createDoctor(DoctorDto dto);

    public DoctorDto updateDoctor(DoctorDto dto);

    public void deleteDoctor(Long id);

    public List<DoctorDto> searchBySpecialization(String specialization);

    public Long countByLocalityAndSpecialization(String specialization, String locality);

}
