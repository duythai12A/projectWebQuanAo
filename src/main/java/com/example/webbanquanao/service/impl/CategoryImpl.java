package com.example.webbanquanao.service.impl;

import com.example.webbanquanao.entity.Category;
import com.example.webbanquanao.repository.CategoryRepository;
import com.example.webbanquanao.service.CategoryService;
import com.example.webbanquanao.service.dto.CategoryDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ObjectMapper objectMapper;

    public CategoryImpl(CategoryRepository categoryRepository, ObjectMapper objectMapper) {
        this.categoryRepository = categoryRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public Category create(CategoryDTO categoryDTO) {
        return categoryRepository.save(objectMapper.convertValue(categoryDTO, Category.class));
    }

    @Override
    public Category update(CategoryDTO categoryDTO) {
        return categoryRepository.save(objectMapper.convertValue(categoryDTO, Category.class));
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
