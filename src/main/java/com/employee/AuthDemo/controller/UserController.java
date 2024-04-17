package com.employee.AuthDemo.controller;

import com.employee.AuthDemo.model.ApiResponse;
import com.employee.AuthDemo.model.UserEntity;
import com.employee.AuthDemo.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/users")
public class UserController {

    @Autowired
    private IUserService service;

@PostMapping("/save")
    public ResponseEntity<ApiResponse> saveUser(@RequestBody UserEntity userEntity){

    var res =  service.createUser(userEntity);

    if(res.isError()){
        return new ResponseEntity<>(res, HttpStatus.BAD_GATEWAY);
    }
    return new ResponseEntity<>(res,HttpStatus.OK);

  }


    @GetMapping("/byId/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable("id") Long id){

        var res = service.getByUserId(id);
        if(res.isError()){
            return new ResponseEntity<>(res,HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UserEntity userEntity){

        var res =  service.updateUser(userEntity);

        if(res.isError()){
            return new ResponseEntity<>(res, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(res,HttpStatus.OK);

    }

}
