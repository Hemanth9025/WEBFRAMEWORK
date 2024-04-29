package com.example.cw1.controller;

import com.example.cw1.model.HemanthPayroll;
import com.example.cw1.service.HemanthPayrollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/{employeeId}/payroll")
public class HemanthPayrollController {
    private final HemanthPayrollService payrollService;

    public HemanthPayrollController(HemanthPayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping
    public ResponseEntity<HemanthPayroll> createPayrollForEmployee(@PathVariable Long employeeId, @RequestBody HemanthPayroll payroll) {
        HemanthPayroll createdPayroll = payrollService.createPayroll(payroll);
        if (createdPayroll != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPayroll);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping
    public ResponseEntity<HemanthPayroll> getPayrollForEmployee(@PathVariable Long employeeId) {
        HemanthPayroll payroll = payrollService.getPayrollByEmployeeId(employeeId);
        if (payroll != null) {
            return ResponseEntity.ok(payroll);
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
