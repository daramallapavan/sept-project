package com.example.MergeJavaAndReactBasic.repository;

import com.example.MergeJavaAndReactBasic.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findByUserEmail(String email);
}
