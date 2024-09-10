package com.example.MergeJavaAndReactBasic.service;

import com.example.MergeJavaAndReactBasic.dto.ImageDto;
import com.example.MergeJavaAndReactBasic.entity.Image;
import com.example.MergeJavaAndReactBasic.entity.Product;
import com.example.MergeJavaAndReactBasic.repository.ImageRepository;
import com.example.MergeJavaAndReactBasic.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{

    private final ImageRepository imageRepository;

    private final ProductRepository productRepository;


    @Override
    public List<ImageDto> addImages(List<MultipartFile> files, Long productId) throws IOException, SQLException {

        Product product=productRepository.findById( productId )
                .orElseThrow(()->new RuntimeException(" product not found"));

        List<ImageDto> savedImageDto=new ArrayList<>();

        for (MultipartFile file:files){
            try {
                Image image = new Image();
                image.setFileType( file.getContentType() );
                image.setFileName( file.getOriginalFilename() );
                image.setImage( new SerialBlob( file.getBytes() ) );

                image.setDownloadUrl("/api/v1/images/image/download/"+image.getId());
                image.setProduct( product );

              Image savedImage=  imageRepository.save( image );

              savedImage.setDownloadUrl( "/api/v1/images/image/download/"+savedImage.getId() );
              imageRepository.save( savedImage );


              ImageDto imageDto=new ImageDto();
              imageDto.setId(savedImage.getId());
              imageDto.setFileName( savedImage.getFileName() );
              imageDto.setDownLoadUrl(  savedImage.getDownloadUrl());

              savedImageDto.add( imageDto );


            }catch (IOException | SQLException e){
                throw new RuntimeException(e.getMessage());
            }
        }
        return savedImageDto;
    }

    @Override
    public Image getImageById(Long imageId) {
       return imageRepository.findById( imageId )
                .orElseThrow(()-> new RuntimeException("image not found"));

    }
}
