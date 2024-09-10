package com.example.MergeJavaAndReactBasic.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/productNew")
@RequiredArgsConstructor
public class ProductNewController {

    private final ProductNewService productNewService;

    @PostMapping("/add")
    public ResponseEntity<?> createProductNew(@RequestBody ProductNew productNew)  {
        ProductNew productNew1 = productNewService.createProductNew( productNew );
        return ResponseEntity.status( HttpStatus.CREATED )
                .body( productNew1 );


    }
    @GetMapping("/get/{productId}")
    public ResponseEntity<?> getProductNew(@PathVariable Long productId){
      ProductNew productNew=  productNewService.getProductNew(productId);
        return ResponseEntity.status( HttpStatus.OK )
                .body(  productNew);
    }
}
