package com.spharosacademy.project.SSGBack.product.Image.entity;


import com.spharosacademy.project.SSGBack.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String imgUrl;
    private String imgTxt;

    @ManyToOne
    private Product product;
}