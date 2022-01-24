package com.ani.finalproject.capstoneproject.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DoctorDto {
    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String specialization;

    @NotNull
    @NotBlank
    private String hospitalNm;

    @NotNull
    @NotBlank
    private String locality;

    @NotNull
    @NotBlank
    private Boolean visiting;

    public DoctorDto(String specialization) {
    }


    }
