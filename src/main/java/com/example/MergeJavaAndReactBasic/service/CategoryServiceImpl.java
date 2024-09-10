package com.example.MergeJavaAndReactBasic.service;

import com.example.MergeJavaAndReactBasic.entity.Category;
import com.example.MergeJavaAndReactBasic.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Category addCategory(String categoryName) {
        Category category=new Category(categoryName);
      return   categoryRepository.save( category );

    }
}
