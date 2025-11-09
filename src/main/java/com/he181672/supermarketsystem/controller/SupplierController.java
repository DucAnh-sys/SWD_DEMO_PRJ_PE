package com.he181672.supermarketsystem.controller;

import com.he181672.supermarketsystem.entity.Supplier;
import com.he181672.supermarketsystem.service.impl.SupplierServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SupplierController {
    private final SupplierServiceImpl supplierService;
    @GetMapping("/supplier")
    public ResponseEntity<List<Supplier>> getActiveSuppliers() {
        List<Supplier> list = supplierService.getAllActiveSuppliers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
