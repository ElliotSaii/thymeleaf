package com.thymeleaf.controller;

import com.thymeleaf.model.Employee;
import com.thymeleaf.repository.EmployeeRepository;
import com.thymeleaf.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("/")
    public String index( Model model){
     return   this.findPaginated(1,"lastName","asc",model);
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable("id")Long id,Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "update_form";
    }


    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id")Long id){
        employeeService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable("pageNo")int pageNo,String sortField,String sortDir,Model model){
        int pageSize=5;
        Page<Employee> page = this.employeeService.findPaginated(pageNo, pageSize,sortField,sortDir);
        List<Employee> employeeList = page.getContent();
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPage",page.getTotalPages());
        model.addAttribute("totalItem",page.getTotalElements());

        String reverseSort = sortDir.equals("desc") ? "asc" : "desc";

        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDir",sortDir);
        model.addAttribute("reverseSort",reverseSort);
        return "index";

    }

}
