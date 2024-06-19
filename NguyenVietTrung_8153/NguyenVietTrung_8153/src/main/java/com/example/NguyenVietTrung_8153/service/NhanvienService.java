package com.example.NguyenVietTrung_8153.service;

import com.example.NguyenVietTrung_8153.model.Nhanvien;
import com.example.NguyenVietTrung_8153.repository.NhanvienRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanvienService {

    private final NhanvienRepository nhanvienRepository;

    @Autowired
    public NhanvienService(NhanvienRepository nhanvienRepository) {
        this.nhanvienRepository = nhanvienRepository;
    }

    // Retrieve all employees from the database
    public List<Nhanvien> getAllEmployees() {
        return nhanvienRepository.findAll();
    }

    // Retrieve an employee by its ID
    public Optional<Nhanvien> getEmployeeById(String id) {
        return nhanvienRepository.findById(id);
    }

    // Add a new employee to the database
    public Nhanvien addEmployee(Nhanvien nhanvien) {
        return nhanvienRepository.save(nhanvien);
    }

    // Update an existing employee
    public Nhanvien updateEmployee(@NotNull Nhanvien nhanvien) {
        Nhanvien existingNhanvien = nhanvienRepository.findById(nhanvien.getMa_NV())
                .orElseThrow(() -> new IllegalStateException("Employee with ID " +
                        nhanvien.getMa_NV() + " does not exist."));
        existingNhanvien.setTen_NV(nhanvien.getTen_NV());
        existingNhanvien.setPhai(nhanvien.getPhai());
        existingNhanvien.setNoi_Sinh(nhanvien.getNoi_Sinh());
        existingNhanvien.setMa_Phong(nhanvien.getMa_Phong());
        existingNhanvien.setLuong(nhanvien.getLuong());
        return nhanvienRepository.save(existingNhanvien);
    }

    // Delete an employee by its ID
    public void deleteEmployeeById(String id) {
        if (!nhanvienRepository.existsById(id)) {
            throw new IllegalStateException("Employee with ID " + id + " does not exist.");
        }
        nhanvienRepository.deleteById(id);
    }
    public Page<Nhanvien> findPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nhanvienRepository.findAll(pageable);
    }
}
