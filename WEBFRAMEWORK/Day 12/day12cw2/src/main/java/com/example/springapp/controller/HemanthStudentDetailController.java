package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.HemathStudentDetail;
import com.example.springapp.service.HemanthStudentDetailService;

@RestController
public class HemanthStudentDetailController {
    @Autowired
    HemanthStudentDetailService studentDetailService;
    
    @PostMapping("/studentDetail/student/{id}")
    public ResponseEntity<HemathStudentDetail> addStudentDetails(@PathVariable int id,@RequestBody HemathStudentDetail studentDetail)
    {
       return new ResponseEntity<>(studentDetailService.addStudentDetail(id,studentDetail),HttpStatus.CREATED);
    }
    
}
