package com.ani.finalproject.capstoneproject.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DoctorInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = false,nullable = true)
    private String name;

    @Column(unique = false,nullable = true)
    private String specialization;

    @Column(unique = false,nullable = false)
    private  String hospitalNm;

    @Column(unique = false,nullable = false)
    private String locality;

    @Column(unique = false,nullable = true)
    private Boolean visiting;

}
