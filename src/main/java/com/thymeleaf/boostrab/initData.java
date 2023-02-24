package com.thymeleaf.boostrab;

import com.thymeleaf.model.Employee;
import com.thymeleaf.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Component
public class initData implements CommandLineRunner {

    public static final List<Employee> employees = Arrays.asList(new Employee(1L,"a","b","sale"),
            new Employee(2L,"c","c","sale"));

    private final EmployeeRepository employeeRepository;



    @Override
    public void run(String... args) throws Exception {
        employeeRepository.saveAll(employees);
    }
}
