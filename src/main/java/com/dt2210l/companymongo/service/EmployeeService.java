package com.dt2210l.companymongo.service;

import com.dt2210l.companymongo.entity.Employee;
import com.dt2210l.companymongo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> addEmployees(List<Employee> employees) {
        employees.forEach(employee -> {
            employee.setSalaries(new HashSet<>());
        });
        System.out.println(employees);
        return employeeRepository.saveAll(employees);
    }
}
