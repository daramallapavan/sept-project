package com.example.MergeJavaAndReactBasic.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class NewImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String fileType;

    private String imageUrl;

    @Lob
    @Column(length = 500000)
    @JsonIgnore
    private Blob image;

    @ManyToOne
    @JoinColumn(name = "pro_id")
    @JsonIgnore
    private ProductNew productNew;
}
