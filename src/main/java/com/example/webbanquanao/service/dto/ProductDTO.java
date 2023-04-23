package com.example.webbanquanao.service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private Long quantity;
    private String name;
    private Float price;
    private String description;
    private Long cartId;
}
