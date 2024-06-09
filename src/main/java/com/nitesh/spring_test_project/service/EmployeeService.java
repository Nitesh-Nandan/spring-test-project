package com.nitesh.spring_test_project.service;

import com.nitesh.spring_test_project.model.Employee;
import com.nitesh.spring_test_project.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        System.out.println("Saved to DB: " + employee);
        return employee;
    }
}
