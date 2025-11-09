package com.he181672.supermarketsystem.controller;

import com.he181672.supermarketsystem.dto.UserDTO;
import com.he181672.supermarketsystem.entity.User;
import com.he181672.supermarketsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        User user = userService.Profile(id);
        return ResponseEntity.ok(user);
    }



}
