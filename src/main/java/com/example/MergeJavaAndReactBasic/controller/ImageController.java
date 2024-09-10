package com.example.MergeJavaAndReactBasic.controller;

import com.example.MergeJavaAndReactBasic.dto.ImageDto;
import com.example.MergeJavaAndReactBasic.entity.Image;
import com.example.MergeJavaAndReactBasic.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/${api.prefix}/images")
@RequiredArgsConstructor
public class ImageController {


    private final ImageService imageService;

    @PostMapping("/add")
    public ResponseEntity<?> addImages(@RequestParam List<MultipartFile> files, @RequestParam Long productId) throws SQLException, IOException {
        List<ImageDto> imagesList = imageService.addImages( files, productId );
        return new ResponseEntity<>( imagesList, HttpStatus.CREATED );
    }


    @GetMapping("/image/download/{imageId}")
    public ResponseEntity<?> downloadImage(@PathVariable Long imageId) throws SQLException {
        Image image = imageService.getImageById( imageId );
        ByteArrayResource resource=
                new ByteArrayResource( image.getImage().getBytes( 1, (int) image.getImage().length() ) );

        return ResponseEntity.ok().contentType( MediaType.parseMediaType( image.getFileType() ) )
                .header( HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+image.getFileName()+"\"" )
                .body( resource );

    }
}
