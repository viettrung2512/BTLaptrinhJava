package com.example.NguyenVietTrung_8153.repository;

import com.example.NguyenVietTrung_8153.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{
    Role findRoleById(Long id);
}

