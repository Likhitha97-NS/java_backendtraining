package com.ani.finalproject.capstoneproject.repository;

import com.ani.finalproject.capstoneproject.domain.DoctorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorInfo, Long> {

    @Modifying
    @Query(value = "update doctor_info set name,specialization,hospitalNm,locality,visiting where id= :id", nativeQuery = true)
    DoctorInfo updateDoctorRepository(@Param("id") DoctorInfo id);

    @Modifying
    @Query(value = "delete from doctor_info where id= :id", nativeQuery = true)
    void deleteDoctorRepository(@Param("id") Long id);

    @Modifying
    @Query(value = "select * from doctor_info where specialization= :specialization", nativeQuery = true)
    List<DoctorInfo> searchBySpecialization(@Param("specialization") String specialization);

    @Modifying
    @Query(value = "select specialization,count(locality) from doctor_info group by specialization;", nativeQuery = true)
    Long countByLocalityAndSpecialization(@Param("specialization") String specialization, @Param("locality") String locality);


}
