package com.example.cw1.controller;

import com.example.cw1.model.HemanthEmployee;
import com.example.cw1.service.HemanthEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class HemanthEmployeeController {
    private final HemanthEmployeeService employeeService;

    public HemanthEmployeeController(HemanthEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<HemanthEmployee> createEmployee(@RequestBody HemanthEmployee employee) {
        HemanthEmployee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping
    public ResponseEntity<List<HemanthEmployee>> getAllEmployees() {
        List<HemanthEmployee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<HemanthEmployee> getEmployeeById(@PathVariable Long employeeId) {
        Optional<HemanthEmployee> employee = employeeService.getEmployeeById(employeeId);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

