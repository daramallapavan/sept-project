package com.example.MergeJavaAndReactBasic.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRegisterDto {
    private String firstName;

    private String lastName;

    private String email;

    private String password;

}
