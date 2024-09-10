package com.example.MergeJavaAndReactBasic.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;


    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL )
   // @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Cart cart;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Orders> orders;





}
