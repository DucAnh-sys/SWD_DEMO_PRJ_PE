package com.he181672.supermarketsystem.repository;

import com.he181672.supermarketsystem.dto.RechargeRequestDTO;
import com.he181672.supermarketsystem.entity.RechargeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechargeRequestRepository extends JpaRepository<RechargeRequest, Integer> {
    RechargeRequest findRechargeRequestByRequestId(Integer requestId);
}
