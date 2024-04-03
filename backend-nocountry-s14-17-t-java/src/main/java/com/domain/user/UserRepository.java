package com.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    boolean existsByUsername(String username);
    User findByUsername(String username);
    List<User> findByEnable(String enable);
}
