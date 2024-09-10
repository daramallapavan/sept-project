package com.example.MergeJavaAndReactBasic.service;

import com.example.MergeJavaAndReactBasic.dto.ProductRequestDto;
import com.example.MergeJavaAndReactBasic.dto.ProductUpdateDto;
import com.example.MergeJavaAndReactBasic.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductRequestDto productRequest);

    List<Product> getAllProducts();


    void deleteProduct(Long productId);


    Product updateProduct(ProductUpdateDto updateRequestDto,Long productId);


    List<Product> getProductsByCategory(String categoryName);
}
