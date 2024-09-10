package com.example.MergeJavaAndReactBasic.dto;

import lombok.Data;

@Data
public class AddToCartDto {

    private Long productId;

    private int quantity;
}
