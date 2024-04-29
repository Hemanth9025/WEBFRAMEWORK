package com.example.ce1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ce1.model.HemanthEmployee;
import com.example.ce1.service.DpakEmployeeService;

@RestController
public class HemanthEmployeeController {
    @Autowired
    DpakEmployeeService employeeService;

    @PostMapping("/employee")
    public HemanthEmployee setMethod(@RequestBody HemanthEmployee employee)
    {
        return employeeService.setEmployee(employee);
    }

    @GetMapping("/employees-inner-join")
    public List<HemanthEmployee> getInnerMethod()
    {
        return employeeService.getInnerEmployee();
    }

    @GetMapping("/employees-left-outer-join")
    public List<HemanthEmployee> getLeftMethod()
    {
        return employeeService.getLeftOuterEmployee();
    }
}
