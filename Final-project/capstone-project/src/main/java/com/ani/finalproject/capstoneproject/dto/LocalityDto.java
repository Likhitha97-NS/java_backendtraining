package com.ani.finalproject.capstoneproject.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Setter
@Getter
public class LocalityDto {

    @NotNull
    @NotBlank
    private String locality;

    @NotNull
    @NotBlank
    private String specialization;
}
