package com.ani.finalproject.capstoneproject.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class DoctorInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull
    @Column(unique = false, nullable = true)
    private String name;

    @NotNull
    @NotBlank
    @Column(unique = false, nullable = true)
    private String specialization;


    @NotBlank
    @Column(unique = false, nullable = false)
    private String hospitalNm;


    @NotBlank
    @Column(unique = false, nullable = false)
    private String locality;

    @Column(unique = false, nullable = true)
    private Boolean visiting;

}
