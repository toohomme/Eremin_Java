package org.ereminegor.spring.service;

import org.ereminegor.spring.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();

    public void save(Employee employee);

    public Employee getEmployee(int id);

    public void delete(int id);
}
