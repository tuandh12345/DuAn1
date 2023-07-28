/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Model;

/**
 *
 * @author Administrator
 */
public class HoaDonCTModel {

    private String MaHDCT;
    private String MaSP;
    private double SoLuong;
    private String MaHD;

    public HoaDonCTModel() {
    }

    public HoaDonCTModel(String MaHDCT, String MaSP, double SoLuong, String MaHD) {
        this.MaHDCT = MaHDCT;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.MaHD = MaHD;
    }

    public String getMaHDCT() {
        return MaHDCT;
    }

    public void setMaHDCT(String MaHDCT) {
        this.MaHDCT = MaHDCT;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public double getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(double SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

}
