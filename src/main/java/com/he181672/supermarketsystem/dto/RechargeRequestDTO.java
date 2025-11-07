package com.he181672.supermarketsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RechargeRequestDTO {
    private int requestId;
    private int userId;
    private String fullName;
    private LocalDateTime createAt;
    private double amount;
    private String status;
    private String action;
}
