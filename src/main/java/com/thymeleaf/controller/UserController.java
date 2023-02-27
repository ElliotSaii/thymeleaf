package com.thymeleaf.controller;

import com.thymeleaf.dto.UserDto;
import com.thymeleaf.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@AllArgsConstructor
@RequestMapping("/registration")
public class UserController {
    private final UserService userService;

    @ModelAttribute("user")
    public UserDto register(){
        return new UserDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }


    @PostMapping
    public String  registerAccount(@ModelAttribute("user")UserDto userDto, HttpSession session){
        userService.saveUser(userDto);
        session.setAttribute("user", userDto);
       return "redirect:/registration?success";
    }

}
