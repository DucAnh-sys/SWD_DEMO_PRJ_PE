package com.he181672.supermarketsystem.controller;

import com.he181672.supermarketsystem.dto.RechargeRequestDTO;
import com.he181672.supermarketsystem.entity.RechargeRequest;
import com.he181672.supermarketsystem.service.RechargeRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RechargeRequestController {
    private final RechargeRequestService rechargeRequestService;


    @PostMapping("/user/deposit")
    public ResponseEntity<?> getRechargeRequest(@RequestBody RechargeRequestDTO rechargeRequestDTO) {
        RechargeRequest rechargeRequest = rechargeRequestService.createRequest(rechargeRequestDTO);
        return ResponseEntity.ok(rechargeRequest);


    }
    @PostMapping("/admin/update-deposit-request")
    public ResponseEntity<?> updateRequest(@RequestBody RechargeRequestDTO dto) {

        String result = rechargeRequestService.updateRequest(dto);

        if (result.equals("Approved") || result.equals("Rejected")) {
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

}
