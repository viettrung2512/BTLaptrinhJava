package com.example.NguyenVietTrung_8153.service;

import com.example.NguyenVietTrung_8153.model.Phongban;
import com.example.NguyenVietTrung_8153.repository.PhongbanRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongbanService {

    private final PhongbanRepository phongbanRepository;

    @Autowired
    public PhongbanService(PhongbanRepository phongbanRepository) {
        this.phongbanRepository = phongbanRepository;
    }

    // Retrieve all departments from the database
    public List<Phongban> getAllDepartments() {
        return phongbanRepository.findAll();
    }

    // Retrieve a department by its ID
//    public Optional<Phongban> getDepartmentById(String id) {
//        return phongbanRepository.findById(id);
//    }

    // Add a new department to the database
    public Phongban addDepartment(Phongban phongban) {
        return phongbanRepository.save(phongban);
    }

    // Update an existing department
    public Phongban updateDepartment(@NotNull Phongban phongban) {
        Phongban existingPhongban = phongbanRepository.findById(phongban.getMa_Phong())
                .orElseThrow(() -> new IllegalStateException("Department with ID " +
                        phongban.getMa_Phong() + " does not exist."));
        existingPhongban.setTen_Phong(phongban.getTen_Phong());
        return phongbanRepository.save(existingPhongban);
    }
    }

