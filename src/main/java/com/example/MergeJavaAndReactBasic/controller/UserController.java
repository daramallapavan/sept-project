package com.example.MergeJavaAndReactBasic.controller;

import com.example.MergeJavaAndReactBasic.dto.UserRegisterDto;
import com.example.MergeJavaAndReactBasic.entity.User;
import com.example.MergeJavaAndReactBasic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${api.prefix}/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/add")
    public ResponseEntity<?> CreateUser(@RequestBody UserRegisterDto registerDto){

      User user=  userService.createUser( registerDto );
        return new ResponseEntity<>( user, HttpStatus.CREATED );
    }

    @GetMapping("/getUser")
    public ResponseEntity<?> getUserByEmailId(@RequestParam String email){

        User user=  userService.getUserByEmail( email );
        return new ResponseEntity<>( user, HttpStatus.OK );
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUsers(){

        List<User> users=  userService.getAll();
        return new ResponseEntity<>( users, HttpStatus.OK );
    }
}
