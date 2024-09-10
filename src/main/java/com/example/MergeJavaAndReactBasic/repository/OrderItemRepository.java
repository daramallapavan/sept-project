package com.example.MergeJavaAndReactBasic.repository;

import com.example.MergeJavaAndReactBasic.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem,Long> {
}
