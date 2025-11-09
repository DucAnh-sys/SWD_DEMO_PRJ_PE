package com.he181672.supermarketsystem.repository;

import com.he181672.supermarketsystem.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    @Query("SELECT s FROM Supplier s WHERE s.isActive = TRUE")
    List<Supplier> findAllSupplierActive();

}
