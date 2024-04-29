package com.example.cw1.service;

import com.example.cw1.model.HemanthPayroll;
import com.example.cw1.repository.HemanthPayrollRepo;
import org.springframework.stereotype.Service;

@Service
public class HemanthPayrollService {
    private final HemanthPayrollRepo payrollRepo;

    public HemanthPayrollService(HemanthPayrollRepo payrollRepo) {
        this.payrollRepo = payrollRepo;
    }

    public HemanthPayroll createPayroll(HemanthPayroll payroll) {
        return payrollRepo.save(payroll);
    }

    public HemanthPayroll getPayrollByEmployeeId(Long employeeId) {
        return payrollRepo.findById(employeeId).orElse(null);
    }
}
