package com.example.MergeJavaAndReactBasic.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductNewRepository extends JpaRepository<ProductNew,Long> {

}
