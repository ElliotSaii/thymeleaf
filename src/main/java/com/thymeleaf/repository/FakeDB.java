package com.thymeleaf.repository;

import com.thymeleaf.model.Employee;

import java.util.Arrays;
import java.util.List;

public class FakeDB {
   public List<Employee> employees = Arrays.asList(new Employee(1L,"a","b","sale"),
            new Employee(1L,"a","b","sale"));


   public List<Employee> getAllEmployees(){
       return  this.employees;
   }
}
