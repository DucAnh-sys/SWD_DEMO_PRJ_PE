package com.he181672.supermarketsystem.repository;

import com.he181672.supermarketsystem.entity.CartItem;
import com.he181672.supermarketsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findUserByUserId(Integer userId);
    User findUserByEmail(String email);
}
