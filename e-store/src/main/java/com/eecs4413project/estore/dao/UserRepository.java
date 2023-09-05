package com.eecs4413project.estore.dao;

import com.eecs4413project.estore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // Add custom query methods here if needed
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
}
