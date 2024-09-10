package com.example.MergeJavaAndReactBasic.service;

import com.example.MergeJavaAndReactBasic.dto.ProductRequestDto;
import com.example.MergeJavaAndReactBasic.dto.ProductUpdateDto;
import com.example.MergeJavaAndReactBasic.entity.Category;
import com.example.MergeJavaAndReactBasic.entity.Product;
import com.example.MergeJavaAndReactBasic.repository.CategoryRepository;
import com.example.MergeJavaAndReactBasic.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;
    @Override
    public Product createProduct(ProductRequestDto productRequest) {

         Category category=
                 Optional.ofNullable(  categoryRepository.findByName( productRequest.getCategory().getName() ))
                         .orElseGet( () -> {
                             Category newCategory=new Category(productRequest.getCategory().getName());

                           return categoryRepository.save( newCategory );
                         } );



         Product product=new Product();
         product.setBrand( productRequest.getBrand() );
         product.setCategory( category );
         product.setDescription( productRequest.getDescription() );
         product.setInventory( productRequest.getInventory() );
         product.setName( productRequest.getName() );
         product.setPrice( productRequest.getPrice() );


         return productRepository.save( product );




    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public void deleteProduct(Long productId) {

        productRepository.findById( productId )
                .ifPresentOrElse( productRepository::delete,()-> new RuntimeException("Product not found") );
    }

    @Override
    public Product updateProduct(ProductUpdateDto updateRequestDto, Long productId) {
        return     productRepository.findById( productId )
                .map( existingProduct-> {
                    Category category=categoryRepository.findByName(updateRequestDto.getCategory().getName()  );

                    existingProduct.setName( updateRequestDto.getName() );
                    existingProduct.setBrand( updateRequestDto.getBrand() );
                    existingProduct.setCategory( category );
                    existingProduct.setDescription( updateRequestDto.getDescription() );
                    existingProduct.setInventory( updateRequestDto.getInventory() );
                    existingProduct.setName( updateRequestDto.getName() );
                    existingProduct.setPrice( updateRequestDto.getPrice() );

                    return    productRepository.save( existingProduct );

                }).orElseThrow(()-> new RuntimeException("Product Not Found"));
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {

        List<Product> products= productRepository.findByCategoryName(categoryName);
        return products;
    }

}
