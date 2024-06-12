package com.happydecor.usermanagement.repository;

import com.happydecor.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> findByIsAdmin(boolean isAdmin);
}
