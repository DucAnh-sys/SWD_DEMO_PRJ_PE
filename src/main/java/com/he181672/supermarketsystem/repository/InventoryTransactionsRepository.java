package com.he181672.supermarketsystem.repository;

import com.he181672.supermarketsystem.entity.InventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryTransactionsRepository extends JpaRepository<InventoryTransaction, Integer> {
}
