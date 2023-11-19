package org.ereminegor.spring.controller;

import org.ereminegor.spring.error.NoSuchEmployeeException;
import org.ereminegor.spring.entity.Employee;
import org.ereminegor.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return service.getAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee = service.getEmployee(id);
        if (employee == null)
            throw new NoSuchEmployeeException("There is no employee with id - " + id);
        return service.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        service.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        service.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = service.getEmployee(id);
        if (employee == null)
            throw new NoSuchEmployeeException("There is no employee with id - " + id);
        service.delete(id);
        return "Employee with id - " + id + " was deleted";
    }
}
