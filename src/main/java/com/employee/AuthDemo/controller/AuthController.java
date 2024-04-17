package com.employee.AuthDemo.controller;

import com.employee.AuthDemo.model.ApiResponse;
import com.employee.AuthDemo.model.AuthRequest;
import com.employee.AuthDemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Auth")
public class AuthController {


    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody AuthRequest request){

        var res = userService.createLogin(request);
        if(res.isError()){
            return new ResponseEntity<>(res, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }




}
