package com.he181672.supermarketsystem.service.impl;

import com.he181672.supermarketsystem.dto.RechargeRequestDTO;
import com.he181672.supermarketsystem.entity.RechargeRequest;
import com.he181672.supermarketsystem.entity.User;
import com.he181672.supermarketsystem.repository.RechargeRequestRepository;
import com.he181672.supermarketsystem.repository.UserRepository;
import com.he181672.supermarketsystem.service.RechargeRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RechargeRequestServiceImpl implements RechargeRequestService {
    private final RechargeRequestRepository rechargeRequestRepository;
    private final UserRepository userRepository;
    @Override
    public List<RechargeRequestDTO> getAllRechargeRequests() {
        List<RechargeRequest> rechargeRequests = rechargeRequestRepository.findAll();
        List<RechargeRequestDTO> rechargeRequestDTOs = new ArrayList<>();
        for (RechargeRequest rechargeRequest : rechargeRequests) {
            RechargeRequestDTO rechargeRequestDTO = new RechargeRequestDTO();
            rechargeRequestDTO.setUserId(rechargeRequest.getUser().getUserId());
            rechargeRequestDTO.setFullName(rechargeRequest.getFullName());
            rechargeRequestDTO.setRequestId(rechargeRequest.getRequestId());
            rechargeRequestDTO.setAmount(rechargeRequest.getAmount().doubleValue());
            rechargeRequestDTO.setCreateAt(rechargeRequest.getCreatedAt());
            rechargeRequestDTO.setStatus(rechargeRequest.getStatus().name());
            rechargeRequestDTOs.add(rechargeRequestDTO);
        }
        return rechargeRequestDTOs;
    }

    @Override
    public RechargeRequest createRequest(RechargeRequestDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User không tồn tại!"));

        RechargeRequest request = RechargeRequest.builder()
                .user(user)
                .fullName(user.getFullName())
                .amount(BigDecimal.valueOf(dto.getAmount()))
                .createdAt(LocalDateTime.now())
                .status(RechargeRequest.Status.Pending)
                .build();

        return rechargeRequestRepository.save(request);
    }

    @Override
    public String updateRequest(RechargeRequestDTO dto) {
        System.out.println(dto.toString());
        RechargeRequest request = rechargeRequestRepository.findRechargeRequestByRequestId(dto.getRequestId());
        if (request == null) {
            return "Recharge request not found!";
        }

        if (dto.getAction().equalsIgnoreCase("APPROVE")) {

            request.setStatus(RechargeRequest.Status.Approved);
            rechargeRequestRepository.save(request);

            User user = userRepository.findUserByUserId(dto.getUserId());
            if (user == null) {
                return "User not found!";
            }

            user.setBalance(user.getBalance() + dto.getAmount());
            userRepository.save(user);

            return "Approved";
        }

        if (dto.getAction().equalsIgnoreCase("REJECT")) {
            request.setStatus(RechargeRequest.Status.Rejected);
            rechargeRequestRepository.save(request);
            return "Rejected";
        }

        return "Invalid action";
    }


}


