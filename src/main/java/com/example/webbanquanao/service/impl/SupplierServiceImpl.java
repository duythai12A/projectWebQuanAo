package com.example.webbanquanao.service.impl;

import com.example.webbanquanao.entity.supplier;
import com.example.webbanquanao.repository.SupplierRepository;
import com.example.webbanquanao.service.SupplierService;
import com.example.webbanquanao.service.dto.SupplierDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;
    private ObjectMapper objectMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ObjectMapper objectMapper) {
        this.supplierRepository = supplierRepository;
        this.objectMapper = objectMapper;
    }

    public supplier create(SupplierDTO supplierDTO){
        return supplierRepository.save(objectMapper.convertValue(supplierDTO, supplier.class));
    }

    public supplier update (SupplierDTO supplierDTO){
        return supplierRepository.save(objectMapper.convertValue(supplierDTO, supplier.class));
    }

    public void delete(Long id){
        supplierRepository.deleteById(id);
    }
}
