package com.employee.AuthDemo.service;

import com.employee.AuthDemo.model.ApiResponse;
import com.employee.AuthDemo.model.AuthRequest;
import com.employee.AuthDemo.model.AuthResponse;
import com.employee.AuthDemo.model.UserEntity;

public interface IUserService {

     ApiResponse<String> createUser(UserEntity user);

     ApiResponse<UserEntity> getByUserId(Long id);


     ApiResponse<String> updateUser(UserEntity userEntity);

     ApiResponse<AuthResponse> createLogin(AuthRequest request);

}
