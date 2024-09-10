package com.example.MergeJavaAndReactBasic.controller;

import com.example.MergeJavaAndReactBasic.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/${api.prefix}/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestParam("name") String categoryName){

        categoryService.addCategory( categoryName );
        return new ResponseEntity<>( "new Category Created "+categoryName , HttpStatus.CREATED );
    }
}
