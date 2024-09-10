package com.example.MergeJavaAndReactBasic.service;

import com.example.MergeJavaAndReactBasic.dto.UserRegisterDto;
import com.example.MergeJavaAndReactBasic.entity.Cart;
import com.example.MergeJavaAndReactBasic.entity.User;
import com.example.MergeJavaAndReactBasic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;

    private final CartService cartService;
    @Override
    public User createUser(UserRegisterDto request) {

        User user=new User();
        user.setEmail( request.getEmail() );
        user.setFirstName( request.getFirstName() );
        user.setLastName( request.getLastName() );
        user.setPassword( request.getPassword() );
        user.setCreatedAt( LocalDateTime.now() );

        User savedUser=   userRepository.save( user );


         cartService.createCart( savedUser );

        return savedUser;
    }

    @Override
    public User getUserByEmail(String email) {

       return userRepository.findByEmail( email )
                .orElseThrow(()-> new RuntimeException(" user not found"));

    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
