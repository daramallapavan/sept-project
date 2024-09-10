package com.example.MergeJavaAndReactBasic.controller;

import com.example.MergeJavaAndReactBasic.dto.ProductRequestDto;
import com.example.MergeJavaAndReactBasic.dto.ProductUpdateDto;
import com.example.MergeJavaAndReactBasic.entity.Product;
import com.example.MergeJavaAndReactBasic.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/${api.prefix}/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductRequestDto productRequestDto){
      Product product= productService.createProduct( productRequestDto );

        return new ResponseEntity<>( "Product Created Success....", HttpStatus.CREATED );
    }


    @GetMapping("all")
    public ResponseEntity<?> getAllProducts(){

      List<Product> productList=  productService.getAllProducts();
      if (productList.isEmpty()){
          return new ResponseEntity<>( "No Products Available ",HttpStatus.OK);
      }

      return new ResponseEntity<>( productList,HttpStatus.OK );



    }

    @DeleteMapping("/{productId}/remove")
    public ResponseEntity<?> removeProduct(@PathVariable Long productId){

        productService.deleteProduct( productId );

        return new ResponseEntity<>( "Product Deleted Success....",HttpStatus.OK);
    }

    @PutMapping("/{productId}/update")
    public ResponseEntity<?> updateProduct(@RequestBody ProductUpdateDto productUpdateDto,
                                           @PathVariable Long productId){

        Product product = productService.updateProduct( productUpdateDto, productId );

        return new ResponseEntity<>( product,HttpStatus.OK );
    }

    @GetMapping("/getProductsByCategory")
    public ResponseEntity<?> getProductsByCategory(@RequestParam("category") String categoryName){
        List<Product> products = productService.getProductsByCategory( categoryName );
        if (products.isEmpty()){
            return new ResponseEntity<>( "Products empty....",HttpStatus.OK );
        }

        return new ResponseEntity<>( products,HttpStatus.OK );
    }
}
