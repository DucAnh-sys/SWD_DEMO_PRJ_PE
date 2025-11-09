package com.he181672.supermarketsystem.repository;

import com.he181672.supermarketsystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByRoleId(Integer roleId);
}
