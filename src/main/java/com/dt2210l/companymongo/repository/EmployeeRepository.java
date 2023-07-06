package com.dt2210l.companymongo.repository;

import com.dt2210l.companymongo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
