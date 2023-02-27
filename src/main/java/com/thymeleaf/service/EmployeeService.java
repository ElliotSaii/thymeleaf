package com.thymeleaf.service;


import com.thymeleaf.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeList();

    void save(Employee employee);

    Employee getEmployeeById(Long id);

    void deleteById(Long id);

    Page<Employee> findPaginated(int pageNo,int pageSize,String sortField,String sortDire);
}
