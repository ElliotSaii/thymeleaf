package com.thymeleaf.controller;

import com.thymeleaf.model.Employee;
import com.thymeleaf.repository.EmployeeRepository;
import com.thymeleaf.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("employeeList",employeeService.getEmployeeList());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }

    @PostMapping("/addNewEmployee")
    public String addNewEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/";
    }
}
