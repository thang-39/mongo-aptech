package com.dt2210l.companymongo.controller;

import com.dt2210l.companymongo.entity.Salary;
import com.dt2210l.companymongo.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping("/employee/{empId}")
    public Set<Salary> addSalariesToEmployee(@PathVariable("empId") int empId,
                                             @RequestBody Set<Salary> salaries) {

        return salaryService.addSalariesByEmployeeId(empId, salaries);
    }
}
