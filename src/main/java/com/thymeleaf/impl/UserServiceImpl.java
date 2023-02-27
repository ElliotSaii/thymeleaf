package com.thymeleaf.impl;

import com.thymeleaf.dto.UserDto;
import com.thymeleaf.model.Role;
import com.thymeleaf.model.User;
import com.thymeleaf.repository.UserRepository;
import com.thymeleaf.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
 private final UserRepository userRepository;

 @Autowired
         @Lazy
BCryptPasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {
        User user =User.builder().
                firstName(userDto.getFirstName())
                        .lastName(userDto.getLastName())
                                .email(userDto.getEmail())
                                        .password(passwordEncoder.encode(userDto.getPassword()))
                                                .roles(Arrays.asList(new Role("ROLE_USER")))
                                                        .build();
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     User user=   userRepository.findByEmail(username);
     if(user==null){
         throw new UsernameNotFoundException("User not found");
     }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        List<SimpleGrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return authorities;
    }
}
