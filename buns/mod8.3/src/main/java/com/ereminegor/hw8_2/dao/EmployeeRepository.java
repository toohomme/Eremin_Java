package com.ereminegor.hw8_2.dao;

import com.ereminegor.hw8_2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
