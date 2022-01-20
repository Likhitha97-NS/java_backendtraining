package com.ani.finalproject.capstoneproject.repository;

import com.ani.finalproject.capstoneproject.domain.DoctorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorInfo,Long> {

}
