package com.example.MergeJavaAndReactBasic.service;

import com.example.MergeJavaAndReactBasic.dto.ImageDto;
import com.example.MergeJavaAndReactBasic.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ImageService {


    List<ImageDto> addImages(List<MultipartFile> files, Long productId) throws IOException, SQLException;


    Image getImageById(Long imageId);
}
