package com.employee.AuthDemo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class AuthResponse {

    Long id;
    String username;
    String token;
    String role;
}
