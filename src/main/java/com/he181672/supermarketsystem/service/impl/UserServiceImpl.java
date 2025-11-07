package com.he181672.supermarketsystem.service.impl;

import com.he181672.supermarketsystem.dto.LoginDTO;
import com.he181672.supermarketsystem.dto.UserDTO;
import com.he181672.supermarketsystem.entity.User;
import com.he181672.supermarketsystem.repository.UserRepository;
import com.he181672.supermarketsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User login(LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername());
        if (user == null) {
            throw new RuntimeException("Username không tồn tại");
        }
        if(!user.getPasswordHash().equals(loginDTO.getPassword())) {
            throw new RuntimeException("Sai mật khẩu");
        }
        if(!user.getIsActive()){
            throw new RuntimeException("Tai khoan bi vo hieu hoa");
        }
        return user;
    }

    @Override
    public User Profile(int userId) {
        return userRepository.findUserByUserId(userId);
    }

    @Override
    public List<UserDTO> manageUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .toList();
    }

}
