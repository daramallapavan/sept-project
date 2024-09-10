package com.example.MergeJavaAndReactBasic.product;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ProductNewService {

    private final ProductNewRepository productNewRepository;

    private final NewImageService newImageService;


    public ProductNew createProductNew(ProductNew productNew) {
    // newImageService.newImageDataSaved( file, productNew.getId() );
        return productNewRepository.save( productNew );
    }

    public ProductNew getProductNew(Long productId) {
       return productNewRepository.findById( productId )
                .orElseThrow(()->new RuntimeException("Product Not Found!"));
    }
}
