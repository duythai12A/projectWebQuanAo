package com.example.webbanquanao.controller;

import com.example.webbanquanao.config.Constants;
import com.example.webbanquanao.entity.Cart;
import com.example.webbanquanao.entity.Product;
import com.example.webbanquanao.entity.supplier;
import com.example.webbanquanao.repository.SupplierRepository;
import com.example.webbanquanao.service.SupplierService;
import com.example.webbanquanao.service.dto.ProductDTO;
import com.example.webbanquanao.service.dto.SupplierDTO;
import com.example.webbanquanao.utils.ResponseBase;
import com.example.webbanquanao.utils.ResponseType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/supplier")
public class SupplierController {
    private SupplierService supplierService;
    private SupplierRepository supplierRepository;
    private ObjectMapper objectMapper;

    public SupplierController(SupplierService supplierService, SupplierRepository supplierRepository, ObjectMapper objectMapper) {
        this.supplierService = supplierService;
        this.supplierRepository = supplierRepository;
        this.objectMapper = objectMapper;
    }
    @PostMapping()
    public ResponseEntity<ResponseBase> create(@RequestBody SupplierDTO supplierDTO){
        ResponseBase responseBase;
        HttpStatus httpStatus;

//        Optional<supplier> supplier = supplierRepository.findById(supplierDTO.getId());
//        if(!supplier.isPresent()){
//            responseBase = new ResponseBase(new Object[]{ResponseType.FAIL,}, ResponseType.FAIL,"404", Constants.NOT_FOUND_Cart);
//            return new ResponseEntity<>(responseBase, HttpStatus.BAD_REQUEST);
//        }
        httpStatus = HttpStatus.OK;
        responseBase = new ResponseBase(new Object[]{supplierService.create(supplierDTO)}, ResponseType.SUCCESS, "");
        return new ResponseEntity<>(responseBase, httpStatus);
    }

    @PutMapping()
    public ResponseEntity<ResponseBase> update(@RequestBody SupplierDTO supplierDTO){
        ResponseBase responseBase;
        HttpStatus httpStatus;

        Optional<supplier> supplier = supplierRepository.findById(supplierDTO.getId());
        if(!supplier.isPresent()){
            responseBase = new ResponseBase(new Object[]{ResponseType.FAIL,}, ResponseType.FAIL,"404", Constants.NOT_FOUND_SUPPLIER);
            return new ResponseEntity<>(responseBase, HttpStatus.BAD_REQUEST);
        }

        httpStatus = HttpStatus.OK;
        responseBase = new ResponseBase(new Object[]{supplierService.update(supplierDTO)}, ResponseType.SUCCESS, "");
        return new ResponseEntity<>(responseBase, httpStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBase> delete(@PathVariable("id") Long id){
        ResponseBase responseBase;
        HttpStatus httpStatus;

        Optional<supplier> supplier = supplierRepository.findById(id);
        if(!supplier.isPresent()){
            responseBase = new ResponseBase(new Object[]{ResponseType.FAIL,}, ResponseType.FAIL,"404", Constants.NOT_FOUND_SUPPLIER);
            return new ResponseEntity<>(responseBase, HttpStatus.BAD_REQUEST);
        }
        supplierService.delete(id);
        httpStatus = HttpStatus.OK;
        responseBase = new ResponseBase(new Object[]{null}, ResponseType.SUCCESS, "");
        return new ResponseEntity<>(responseBase, httpStatus);
    }
}
