package com.thymeleaf.controller;

import com.thymeleaf.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model){
        Object user = model.getAttribute("user");
        return "login";
    }

}
