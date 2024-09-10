package com.example.MergeJavaAndReactBasic.dto;

import com.example.MergeJavaAndReactBasic.entity.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateDto {
    private String name;
    private String brand;

    private BigDecimal price;
    private int inventory;
    private String description;

    private Category category;
}
