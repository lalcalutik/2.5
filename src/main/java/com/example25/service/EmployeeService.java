package com.example25.service;

import com.example25.exception.EmployeeAlreadyAddedException;
import com.example25.exception.EmployeeNotFoundException;
import com.example25.exception.EmployeeStorageIsFullException;
import com.example25.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service

public class EmployeeService {
    private final int SIZE = 5;
    private final List<Employee> employees = new ArrayList<>(SIZE);
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() < SIZE) {
            for (Employee emp : employees) {
                if (emp.equals(employee)) {
                    throw new EmployeeAlreadyAddedException();
                }
            }
            employees.add(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();

    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.remove(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();

    }

    public List<Employee> list() {
        return Collections.unmodifiableList(employees);
    }
}
