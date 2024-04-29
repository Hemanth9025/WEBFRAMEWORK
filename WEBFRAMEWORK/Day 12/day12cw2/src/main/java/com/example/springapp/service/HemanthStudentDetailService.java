package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.HemathStudentDetail;
import com.example.springapp.repository.HemanthStudentDetailRepository;
import com.example.springapp.repository.HemanthStudentRepository;

@Service
public class HemanthStudentDetailService {
    @Autowired
    HemanthStudentDetailRepository studentDetailRepository;
    @Autowired
    HemanthStudentRepository studentRepository;
    public HemathStudentDetail addStudentDetail(int id,HemathStudentDetail studentDetail)
    {
        if(studentRepository.existsById(id))
        {
            studentDetailRepository.addStudentDetail(studentDetail.getAddress(),studentDetail.getPhoneNumber(),id);
            return studentDetail;
        }
        else
        return null;
    }
    
    
}
