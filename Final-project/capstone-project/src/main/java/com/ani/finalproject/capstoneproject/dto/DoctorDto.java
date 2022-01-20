package com.ani.finalproject.capstoneproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class DoctorDto {
    private Long id;
    private String name;
    private String specialization;
    private String hospitalNm;
    private String locality;
    private Boolean visiting;

}
