package com.thymeleaf.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum Role {

    ADMIN("admin"),USER("user"),MANAGER("manager"),TESTER("tester");
    private String name;

}
