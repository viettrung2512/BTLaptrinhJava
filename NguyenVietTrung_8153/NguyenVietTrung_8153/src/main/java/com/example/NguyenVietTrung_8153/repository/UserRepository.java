package com.example.NguyenVietTrung_8153.repository;

import com.example.NguyenVietTrung_8153.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
