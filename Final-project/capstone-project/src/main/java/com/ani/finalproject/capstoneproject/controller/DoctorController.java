package com.ani.finalproject.capstoneproject.controller;

import com.ani.finalproject.capstoneproject.dto.AppResponse;
import com.ani.finalproject.capstoneproject.dto.DoctorDto;
import com.ani.finalproject.capstoneproject.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/doctor")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping
    public ResponseEntity<AppResponse<DoctorDto>> createDoctor(@RequestBody DoctorDto dto){
        var svObj=service.createDoctor(dto);

        var response=new AppResponse<DoctorDto>();
        response.setStatus("Success");
        response.setMessage("doctor saved successfully");
        response.setBody(svObj);
        return ResponseEntity.ok(response);
    }
}
