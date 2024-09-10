package com.example.MergeJavaAndReactBasic.repository;

import com.example.MergeJavaAndReactBasic.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Orders,Long> {
}
