package com.he181672.supermarketsystem.service;

import com.he181672.supermarketsystem.dto.RechargeRequestDTO;
import com.he181672.supermarketsystem.entity.RechargeRequest;

import java.util.List;

public interface RechargeRequestService {
    List<RechargeRequestDTO> getAllRechargeRequests();

    RechargeRequest createRequest(RechargeRequestDTO rechargeRequestDTO);

    String updateRequest(RechargeRequestDTO rechargeRequestDTO);
}
