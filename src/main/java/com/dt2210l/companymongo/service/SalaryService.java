package com.dt2210l.companymongo.service;

import com.dt2210l.companymongo.entity.Employee;
import com.dt2210l.companymongo.entity.Salary;
import com.dt2210l.companymongo.repository.EmployeeRepository;
import com.dt2210l.companymongo.repository.SalaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SalaryService {

    private final EmployeeRepository employeeRepository;
    private final SalaryRepository salaryRepository;


    public Set<Salary> addSalariesByEmployeeId(int empId, Set<Salary> salaries) {
        Employee employee = employeeRepository.findById(empId).get();
        Set<Salary> salaryOld = employee.getSalaries();

        salaries.forEach(salary -> {
            salary.setEmployee(employee);
            salaryRepository.save(salary);
            salaryOld.add(salary);
        });

        employee.setSalaries(salaryOld);
        employeeRepository.save(employee);
        return salaryOld;
    }
}

