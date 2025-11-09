package com.he181672.supermarketsystem.dto;


import com.he181672.supermarketsystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer userId;
    private String username;
    private String email;
    private String role;
    private String fullName;
    private double balance;
    private boolean active;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.role = user.getRole().getRoleName();
        this.fullName = user.getFullName();
        this.balance = user.getBalance();
        this.active = user.getIsActive();
    }
}

