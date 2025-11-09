package com.he181672.supermarketsystem.service.impl;

import com.he181672.supermarketsystem.dto.LoginDTO;
import com.he181672.supermarketsystem.dto.RegisterDTO;
import com.he181672.supermarketsystem.dto.UserDTO;
import com.he181672.supermarketsystem.entity.User;
import com.he181672.supermarketsystem.repository.RoleRepository;
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
    private final RoleRepository roleRepository;
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
    public List<UserDTO> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .toList();
    }

    @Override
    public User registerUser(RegisterDTO dto) {
        User user = userRepository.findByUsername(dto.getUsername());
        if(user != null) {
            throw new RuntimeException(" UserName đã tồn tại");
        }
        if (userRepository.findUserByEmail(dto.getEmail()) != null) {
            throw new RuntimeException("Email đã tồn tại");
        }
        if(!dto.getPhoneNumber().matches("^\\d{9,11}$")) {
            throw new RuntimeException("Số điện thoại không hợp lệ");
        }

        User newUser = new User();
        newUser.setUsername(dto.getUsername());
        newUser.setPasswordHash(dto.getPassword());
        newUser.setRole(
                roleRepository.findRoleByRoleId(
                        dto.getRole() != null ? dto.getRole() : 1
                )
        );

        newUser.setFullName(dto.getFullName());
        newUser.setEmail(dto.getEmail());
        newUser.setPhoneNumber(dto.getPhoneNumber());
        newUser.setAddress(dto.getAddress());
        newUser.setBalance(0.0);
        newUser.setIsActive(true);
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public User updateUser(int userId, UserDTO dto) {
        User user = userRepository.findUserByUserId(userId);
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setBalance(dto.getBalance());
        user.setUsername(dto.getUsername());
        userRepository.save(user);
        return user;
    }




}
