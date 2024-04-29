package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.HemanthStudent;
import com.example.springapp.repository.HemanthStudentRepository;

@Service
public class HemanthStudentService {
    @Autowired
    HemanthStudentRepository studentRepository;
    public HemanthStudent addStudents(HemanthStudent student)
    {
        return studentRepository.save(student);
    }
    public List<HemanthStudent>getStudent()
    {
        return studentRepository.findAll();
    }
    public List<HemanthStudent>getStudentInner()
    {
        return studentRepository.getStudentInner();
    }
    public List<HemanthStudent>getStudentLeftOuter()
    {
        return studentRepository.getStudentsLeftOuter();
    }
    
}
