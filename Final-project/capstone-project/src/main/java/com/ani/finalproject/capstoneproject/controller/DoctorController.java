package com.ani.finalproject.capstoneproject.controller;

import com.ani.finalproject.capstoneproject.domain.DoctorInfo;
import com.ani.finalproject.capstoneproject.dto.AppResponse;
import com.ani.finalproject.capstoneproject.dto.DoctorDto;
import com.ani.finalproject.capstoneproject.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/doctor")
@RestController
public class DoctorController {

    private final Logger logger = LoggerFactory.getLogger(DoctorController.class);
    @Autowired
    private DoctorService service;


    @PostMapping //http://localhost:8080/doctor
    public ResponseEntity<AppResponse<DoctorDto>> createDoctor(@RequestBody DoctorDto dto) {
        var svObj = service.createDoctor(dto);

        var response = new AppResponse<DoctorDto>();
        response.setStatus("Success");
        response.setMessage("doctor saved successfully");
        response.setBody(svObj);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<AppResponse<DoctorDto>> updateDocInfo(@RequestBody DoctorDto dto) {

        var svObj = service.updateDoctor(dto);
        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor updated successfully");
        response.setBody(svObj);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AppResponse<DoctorDto>> deleteDoctor(@PathVariable("id") Long id) {
        service.deleteDoctor(id);
        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor deleted successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<AppResponse<List<DoctorDto>>> searchBySpecialization(@PathVariable("specialization") String specialization) {
       var dto= service.searchBySpecialization(specialization);
        var response = new AppResponse<List<DoctorDto>>();
        response.setStatus("success");
        response.setMessage("Doctor fetched successfully by specialization");
        response.setBody(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/count/{spec}/{loc}")
    public ResponseEntity<AppResponse<Long>> countByLocalityAndSpecialization(@PathVariable("spec") String specialization, @PathVariable("loc") String locality) {
        var count = service.countByLocalityAndSpecialization(specialization, locality);
        var response = new AppResponse<Long>();
        response.setStatus("Success");
        response.setMessage("Available doctors are");
        response.setBody(count);
        return ResponseEntity.ok(response);
    }
}
