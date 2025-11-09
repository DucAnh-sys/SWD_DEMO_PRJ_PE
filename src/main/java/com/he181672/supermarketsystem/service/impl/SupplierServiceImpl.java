package com.he181672.supermarketsystem.service.impl;

import com.he181672.supermarketsystem.entity.Supplier;
import com.he181672.supermarketsystem.repository.SupplierRepository;
import com.he181672.supermarketsystem.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    @Override
    public List<Supplier> getAllActiveSuppliers() {
        return supplierRepository.findAllSupplierActive();
    }
}
