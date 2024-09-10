package com.example.MergeJavaAndReactBasic.product;

import com.example.MergeJavaAndReactBasic.entity.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/newImage")
@RequiredArgsConstructor
public class NewImageController {

    private final NewImageService newImageService;


    @PostMapping("/add/{productId}")
    public String addImagesToProductId(@RequestParam("image") List<MultipartFile> files, @PathVariable Long productId) throws IOException, SQLException {
        String response = newImageService.newImageDataSaved( files, productId );

        return response;


    }

    @GetMapping("/download/{imageId}")
    public ResponseEntity<?> downloadNewImage(@PathVariable Long imageId) throws SQLException {
        NewImageData image = newImageService.getImage( imageId );
        ByteArrayResource resource =
                new ByteArrayResource( image.getImage().getBytes( 1,(int)image.getImage().length() ) );
        //  new ByteArrayResource( image.getImage().getBytes( 1, (int) image.getImage().length() ) );

        return ResponseEntity.ok().contentType( MediaType.parseMediaType( image.getFileType() ) )
                .header( HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFileName() + "\"" )
                .body( resource );
    }
}
