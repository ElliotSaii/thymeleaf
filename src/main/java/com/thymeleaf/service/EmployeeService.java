package com.thymeleaf.service;


import com.thymeleaf.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeList();

    void save(Employee employee);
}
