package com.example.webbanquanao.service.impl;

import com.example.webbanquanao.entity.Product;
import com.example.webbanquanao.repository.CartRepository;
import com.example.webbanquanao.repository.ProductRepository;
import com.example.webbanquanao.service.ProductService;
import com.example.webbanquanao.service.dto.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    private final ObjectMapper objectMapper;

    public ProductServiceImpl(ObjectMapper objectMapper, ProductRepository productRepository, CartRepository cartRepository) {
        this.objectMapper = objectMapper;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public Page<ProductDTO> search(Pageable pageable) {
        List<ProductDTO> productList = Arrays.asList(objectMapper.convertValue(productRepository.findAll(), ProductDTO[].class));
        int size = productList.size();
        final int start = (int) pageable.getOffset();
        final int end = Math.min(start + pageable.getPageSize(), size);
        List<ProductDTO> result = new ArrayList<>();
        if(start <= end)
            result = productList.subList(start, end);
        return new PageImpl<>(result, pageable, size);
    }

    @Override
    public Product create(ProductDTO productDTO) {
        return productRepository.save(objectMapper.convertValue(productDTO, Product.class));
    }

    @Override
    public Product update(ProductDTO productDTO) {
        return productRepository.save(objectMapper.convertValue(productDTO, Product.class));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
