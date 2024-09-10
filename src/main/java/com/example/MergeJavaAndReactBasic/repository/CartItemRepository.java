package com.example.MergeJavaAndReactBasic.repository;

import com.example.MergeJavaAndReactBasic.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository  extends JpaRepository<CartItem,Long> {
}
