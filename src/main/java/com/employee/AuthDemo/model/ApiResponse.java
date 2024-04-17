package com.employee.AuthDemo.model;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ApiResponse <T>{
    private T data;
    private boolean error;
    private String message;




    public static <T> ApiResponse<T> of(T data, String message){
        return ApiResponse.<T>builder()
                .data(data)
                .error(false)
                .message(message)
                .build();
    }

    public static <T> ApiResponse<T> ofError(T data, String message){

        return ApiResponse.<T>builder().data(data)
                .error(true)
                .message(message)
                .build();
    }


}

