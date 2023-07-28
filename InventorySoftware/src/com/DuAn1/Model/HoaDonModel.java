/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author Administrator
 */
public class HoaDonModel {

    private String MaHD;
    private double Soluong;
    private boolean TrangThai;
    private double Dongia;
    private double Tongtien;
    private String NgayXuat;
    private String Mota;
    private String TenCty;
    private String MaNV;

    public HoaDonModel() {
    }

    public HoaDonModel(String MaHD, double Soluong, boolean TrangThai, double Dongia, double Tongtien, String NgayXuat, String Mota, String TenCty, String MaNV) {
        this.MaHD = MaHD;
        this.Soluong = Soluong;
        this.TrangThai = TrangThai;
        this.Dongia = Dongia;
        this.Tongtien = Tongtien;
        this.NgayXuat = NgayXuat;
        this.Mota = Mota;
        this.TenCty = TenCty;
        this.MaNV = MaNV;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public double getSoluong() {
        return Soluong;
    }

    public void setSoluong(double Soluong) {
        this.Soluong = Soluong;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public double getDongia() {
        return Dongia;
    }

    public void setDongia(double Dongia) {
        this.Dongia = Dongia;
    }

    public double getTongtien() {
        return Tongtien;
    }

    public void setTongtien(double Tongtien) {
        this.Tongtien = Tongtien;
    }

    public String getNgayXuat() {
        return NgayXuat;
    }

    public void setNgayXuat(String NgayXuat) {
        this.NgayXuat = NgayXuat;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public String getTenCty() {
        return TenCty;
    }

    public void setTenCty(String TenCty) {
        this.TenCty = TenCty;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

}
