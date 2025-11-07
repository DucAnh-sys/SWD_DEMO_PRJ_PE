package com.he181672.supermarketsystem.dto;

import com.he181672.supermarketsystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private int userId;
    private String username;
    private String fullName;
    private Role role;
}
