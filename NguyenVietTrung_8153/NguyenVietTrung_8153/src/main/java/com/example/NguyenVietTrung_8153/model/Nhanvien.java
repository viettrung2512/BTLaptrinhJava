package com.example.NguyenVietTrung_8153.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "NHANVIEN")
public class Nhanvien {
    @Id
    @Length(max = 3)
    private String Ma_NV;

    @Length(max = 100)
    private String Ten_NV;

    @Length(max = 3)
    private String Phai;

    @Length(max = 200)
    private String Noi_Sinh;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private Phongban Ma_Phong;

    private int Luong;


    public String getMa_NV() {
        return Ma_NV;
    }

    public void setMa_NV(String ma_NV) {
        Ma_NV = ma_NV;
    }

    public String getTen_NV() {
        return Ten_NV;
    }

    public void setTen_NV(String ten_NV) {
        Ten_NV = ten_NV;
    }

    public String getPhai() {
        return Phai;
    }

    public void setPhai(String phai) {
        Phai = phai;
    }

    public String getNoi_Sinh() {
        return Noi_Sinh;
    }

    public void setNoi_Sinh(String noi_Sinh) {
        Noi_Sinh = noi_Sinh;
    }

    public Phongban getMa_Phong() {
        return Ma_Phong;
    }

    public void setMa_Phong(Phongban ma_Phong) {
        Ma_Phong = ma_Phong;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int luong) {
        Luong = luong;
    }

}
