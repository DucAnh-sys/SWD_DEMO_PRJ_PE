package com.he181672.supermarketsystem.controller;

import com.he181672.supermarketsystem.dto.LoginDTO;
import com.he181672.supermarketsystem.dto.LoginResponseDTO;
import com.he181672.supermarketsystem.dto.RegisterDTO;
import com.he181672.supermarketsystem.entity.User;
import com.he181672.supermarketsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {
    private final UserService userService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        User user = userService.login(loginDTO);

        LoginResponseDTO response = new LoginResponseDTO(
                user.getUserId(),
                user.getUsername(),
                user.getFullName(),
                user.getRole()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/auth/register")
    public ResponseEntity<User> register(@RequestBody RegisterDTO registerDTO) {
        User user = userService.registerUser(registerDTO);
        return ResponseEntity.ok(user);
    }

}
