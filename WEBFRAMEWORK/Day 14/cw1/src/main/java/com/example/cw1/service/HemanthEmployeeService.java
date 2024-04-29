package com.example.cw1.service;

import com.example.cw1.model.HemanthEmployee;
import com.example.cw1.repository.HemanthEmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HemanthEmployeeService {
    private final HemanthEmployeeRepo employeeRepo;

    public HemanthEmployeeService(HemanthEmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public HemanthEmployee createEmployee(HemanthEmployee employee) {
        return employeeRepo.save(employee);
    }

    public List<HemanthEmployee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<HemanthEmployee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }
}
