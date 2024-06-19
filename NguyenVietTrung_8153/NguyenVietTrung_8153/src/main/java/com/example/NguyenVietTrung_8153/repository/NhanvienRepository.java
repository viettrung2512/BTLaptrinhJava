package com.example.NguyenVietTrung_8153.repository;

import com.example.NguyenVietTrung_8153.model.Nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanvienRepository extends JpaRepository<Nhanvien, String> {
}