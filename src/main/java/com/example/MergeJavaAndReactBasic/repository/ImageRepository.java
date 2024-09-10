package com.example.MergeJavaAndReactBasic.repository;

import com.example.MergeJavaAndReactBasic.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
}
