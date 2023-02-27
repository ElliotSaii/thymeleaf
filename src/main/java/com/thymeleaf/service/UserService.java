package com.thymeleaf.service;

import com.thymeleaf.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void  saveUser(UserDto userDto);
}
