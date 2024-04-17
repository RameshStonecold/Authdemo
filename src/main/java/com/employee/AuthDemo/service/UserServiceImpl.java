package com.employee.AuthDemo.service;

import com.employee.AuthDemo.model.ApiResponse;
import com.employee.AuthDemo.model.AuthRequest;
import com.employee.AuthDemo.model.AuthResponse;
import com.employee.AuthDemo.model.UserEntity;
import com.employee.AuthDemo.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserEntityRepository repository;


    @Override
    public ApiResponse<String> createUser(UserEntity user) {

        var res = repository.findByUsername(user.getUsername());

        if(res.isEmpty())
        {
            return ApiResponse.ofError(null,"Not found");
        }
        return ApiResponse.of(res.get().getUsername(),"Success");
    }

    @Override
    public ApiResponse<UserEntity> getByUserId(Long id) {
        var res =repository.findById(id);
        if(res.isEmpty())
        {
            return ApiResponse.ofError(null,"Not found");
        }
        return ApiResponse.of(res.get(),"Success");
    }


    @Override
    public ApiResponse<String> updateUser(UserEntity userEntity) {

        var result =this.getByUserId(userEntity.getId());
        if(result.isError()){
            return ApiResponse.of(result.getMessage(), result.getMessage());
        }
        var res = repository.save(userEntity);
        return ApiResponse.of(res.getUsername(),"Updated Successful");

    }

    @Override
    public ApiResponse<AuthResponse> createLogin(AuthRequest request) {

        return null;
    }


}
