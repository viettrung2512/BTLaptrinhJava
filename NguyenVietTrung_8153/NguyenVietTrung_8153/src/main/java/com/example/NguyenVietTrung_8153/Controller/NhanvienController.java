package com.example.NguyenVietTrung_8153.Controller;

import com.example.NguyenVietTrung_8153.model.Nhanvien;
import com.example.NguyenVietTrung_8153.service.PhongbanService;
import com.example.NguyenVietTrung_8153.service.NhanvienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Controller
@RequestMapping("/nhanvien")
public class NhanvienController {

    @Autowired
    private NhanvienService nhanvienService;

    @Autowired
    private PhongbanService phongbanService;

    // Display a list of all employees
    @GetMapping
    public String showNhanVienList(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Nhanvien> nhanVienPage = nhanvienService.findPaginated(page, 5);
        model.addAttribute("nhanViens", nhanVienPage);
        model.addAttribute("currentPage", page);
        return "nhanvien/nhanvien-list";
    }

    // For adding a new employee
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanvien", new Nhanvien());
        model.addAttribute("phongbans", phongbanService.getAllDepartments());
        return "nhanvien/add-nhanvien";
    }

    // Process the form for adding a new employee
    @PostMapping("/add")
    public String addNhanvien(@Valid Nhanvien nhanvien, BindingResult result) {
        nhanvienService.addEmployee(nhanvien);
        return "redirect:/nhanvien";
    }

    // For editing an employee
    @GetMapping("/edit/{Ma_NV}")
    public String showEditForm(@PathVariable String Ma_NV, Model model) {
        Nhanvien nhanvien = nhanvienService.getEmployeeById(Ma_NV)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + Ma_NV));
        model.addAttribute("nhanVien", nhanvien);
        model.addAttribute("phongbans", phongbanService.getAllDepartments());
        return "nhanvien/update-nhanvien";
    }

    // Process the form for updating an employee
    @PostMapping("/edit/{Ma_NV}")
    public String updateEmployee(@PathVariable String Ma_NV, @Valid Nhanvien nhanvien, BindingResult result) {
        if (result.hasErrors()) {
            nhanvien.setMa_NV(Ma_NV);
            return "nhanvien/update-nhanvien";
        }
        nhanvienService.updateEmployee(nhanvien);
        return "redirect:/nhanvien";
    }

    // Handle request to delete an employee
    @GetMapping("/delete/{Ma_NV}")
    public String deleteEmployee(@PathVariable String Ma_NV) {
        nhanvienService.deleteEmployeeById(Ma_NV);
        return "redirect:/nhanvien";
    }
}
