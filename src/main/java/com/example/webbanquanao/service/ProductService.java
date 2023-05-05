package com.example.webbanquanao.service;

import com.example.webbanquanao.entity.Product;
import com.example.webbanquanao.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<ProductDTO> search(Pageable pageable);

    Product create(ProductDTO productDTO);

    Product update(ProductDTO productDTO);

    void delete(Long id);

}
