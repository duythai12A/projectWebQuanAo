package com.example.webbanquanao.service;

import com.example.webbanquanao.entity.supplier;
import com.example.webbanquanao.service.dto.SupplierDTO;

public interface SupplierService {
    supplier create(SupplierDTO supplierDTO);

    supplier update(SupplierDTO supplierDTO);

    void delete(Long id);
}
