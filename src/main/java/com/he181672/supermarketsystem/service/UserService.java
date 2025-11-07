package com.he181672.supermarketsystem.service;


import com.he181672.supermarketsystem.dto.LoginDTO;
import com.he181672.supermarketsystem.dto.UserDTO;
import com.he181672.supermarketsystem.entity.User;

import java.util.List;

public interface UserService {
    User login(LoginDTO loginDTO);

    User Profile(int userId);

    List<UserDTO> manageUsers();
}
