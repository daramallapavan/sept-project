package com.example.MergeJavaAndReactBasic.product;

import com.example.MergeJavaAndReactBasic.entity.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewImageService {

    private final NewImageDataRepository newImageDataRepository;

    private final ProductNewRepository productNewRepository;

    public String newImageDataSaved(List<MultipartFile> files, Long productId) throws IOException, SQLException {

       ProductNew product= productNewRepository.findById( productId )
                        .orElseThrow(()-> new RuntimeException("product not found!"));

       if (product!=null){


           for (MultipartFile file:files){
               NewImageData image = new NewImageData();

               image.setFileName( file.getOriginalFilename() );
               image.setFileType( file.getContentType() );
               //image.setImage( ImageUtils.compressImage( file.getBytes() ) );
               image.setImage( new SerialBlob( file.getBytes() ) );
               image.setProductNew( product );
               image.setImageUrl( "http://localhost:8090/api/newImage/download/"+image.getId() );


               NewImageData savedImageData = newImageDataRepository.save( image );

               savedImageData.setImageUrl( "http://localhost:8090/api/newImage/download/"+savedImageData.getId() );

               newImageDataRepository.save( savedImageData );

           }


       }


        return "File Stored in Service ,"+productId;
    }


    public NewImageData getImage(Long imageId) {

      return newImageDataRepository.findById( imageId )
                .orElseThrow(()-> new RuntimeException("image not found"));
    }
}
