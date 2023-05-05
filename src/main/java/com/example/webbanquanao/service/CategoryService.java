package com.example.webbanquanao.service;

import com.example.webbanquanao.entity.Category;
import com.example.webbanquanao.service.dto.CategoryDTO;

public interface CategoryService {
    Category create(CategoryDTO categoryDTO);

    Category update(CategoryDTO categoryDTO);

    void delete(Long id);
}
