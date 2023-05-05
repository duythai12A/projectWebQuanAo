package com.example.webbanquanao.controller;

import com.example.webbanquanao.config.Constants;
import com.example.webbanquanao.entity.Cart;
import com.example.webbanquanao.entity.Category;
import com.example.webbanquanao.entity.Product;
import com.example.webbanquanao.repository.CategoryRepository;
import com.example.webbanquanao.service.CategoryService;
import com.example.webbanquanao.service.dto.CategoryDTO;
import com.example.webbanquanao.service.dto.ProductDTO;
import com.example.webbanquanao.utils.ResponseBase;
import com.example.webbanquanao.utils.ResponseType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/catergory")
public class CatergoryConTroller {
    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;
    private final ObjectMapper objectMapper;

    public CatergoryConTroller(CategoryService categoryService, CategoryRepository categoryRepository, ObjectMapper objectMapper) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
        this.objectMapper = objectMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBase> getById(@PathVariable("id") Long id){
        ResponseBase responseBase;
        HttpStatus httpStatus;

        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent()){
            responseBase = new ResponseBase(new Object[]{ResponseType.FAIL,}, ResponseType.FAIL,"404", Constants.NOT_FOUND_PRODUCT);
            return new ResponseEntity<>(responseBase, HttpStatus.BAD_REQUEST);
        }
        CategoryDTO categoryDTO = objectMapper.convertValue(category.get(), CategoryDTO.class);
        httpStatus = HttpStatus.OK;
        responseBase = new ResponseBase(new Object[]{categoryDTO}, ResponseType.SUCCESS, "");
        return new ResponseEntity<>(responseBase, httpStatus);
    }

    @PostMapping()
    public ResponseEntity<ResponseBase> create(@RequestBody CategoryDTO categoryDTO){
        ResponseBase responseBase;
        HttpStatus httpStatus;

        httpStatus = HttpStatus.OK;
        responseBase = new ResponseBase(new Object[]{categoryService.create(categoryDTO)}, ResponseType.SUCCESS, "");
        return new ResponseEntity<>(responseBase, httpStatus);
    }

    @PutMapping()
    public ResponseEntity<ResponseBase> update(@RequestBody CategoryDTO categoryDTO){
        ResponseBase responseBase;
        HttpStatus httpStatus;

        Optional<Category> category = categoryRepository.findById(categoryDTO.getId());
        if(!category.isPresent()){
            responseBase = new ResponseBase(new Object[]{ResponseType.FAIL,}, ResponseType.FAIL,"404", Constants.NOT_FOUND_CATEGORY);
            return new ResponseEntity<>(responseBase, HttpStatus.BAD_REQUEST);
        }

        httpStatus = HttpStatus.OK;
        responseBase = new ResponseBase(new Object[]{categoryService.update(categoryDTO)}, ResponseType.SUCCESS, "");
        return new ResponseEntity<>(responseBase, httpStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBase> delete(@PathVariable("id") Long id){
        ResponseBase responseBase;
        HttpStatus httpStatus;

        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent()){
            responseBase = new ResponseBase(new Object[]{ResponseType.FAIL,}, ResponseType.FAIL,"404", Constants.NOT_FOUND_CATEGORY);
            return new ResponseEntity<>(responseBase, HttpStatus.BAD_REQUEST);
        }
        categoryService.delete(id);
        httpStatus = HttpStatus.OK;
        responseBase = new ResponseBase(new Object[]{null}, ResponseType.SUCCESS, "");
        return new ResponseEntity<>(responseBase, httpStatus);
    }
}
