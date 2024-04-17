package com.employee.AuthDemo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AuthRequest {

    String username;
    String password;
    String role;

}
