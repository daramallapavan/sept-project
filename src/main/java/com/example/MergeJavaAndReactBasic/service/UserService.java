package com.example.MergeJavaAndReactBasic.service;

import com.example.MergeJavaAndReactBasic.dto.UserRegisterDto;
import com.example.MergeJavaAndReactBasic.entity.User;

import java.util.List;

public interface UserService {

    User createUser(UserRegisterDto request);

    User getUserByEmail(String email);

    List<User> getAll();
}
