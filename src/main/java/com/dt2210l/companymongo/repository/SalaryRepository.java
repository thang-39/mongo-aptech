package com.dt2210l.companymongo.repository;

import com.dt2210l.companymongo.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
}
