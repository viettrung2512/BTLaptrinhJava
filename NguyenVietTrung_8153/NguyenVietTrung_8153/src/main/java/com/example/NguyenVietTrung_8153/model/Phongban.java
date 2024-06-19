package com.example.NguyenVietTrung_8153.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "PHONGBAN")
public class Phongban {
    @Id
    @Length(max = 2)
    private String Ma_Phong;

    @Length(max = 30)
    private String Ten_Phong;

    // Getters and setters

    public String getMa_Phong() {
        return Ma_Phong;
    }

    public void setMa_Phong(String ma_Phong) {
        Ma_Phong = ma_Phong;
    }

    public String getTen_Phong() {
        return Ten_Phong;
    }

    public void setTen_Phong(String ten_Phong) {
        Ten_Phong = ten_Phong;
    }
}
