/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL E5470
 */
public class ThongKeDao {

    public List<Object[]> getSoLuongSP() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call maxMaSP}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaxProductCode").trim(),};

                    list.add(model);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> DoanhThuThang() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_thongke_doanhthu_thang}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {rs.getString("NgayXuat"),
                        rs.getString("DoanhThu")};

                    list.add(model);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getSoLuongNV() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call maxMaNV}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaxProductCode").trim(),};

                    list.add(model);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getSoLuongGG() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call MaxMaGG}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaxProductCode").trim(),};

                    list.add(model);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getSoLuongKH() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call MaxMaKH}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaxProductCode").trim(),};

                    list.add(model);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getMaxMaDatSP() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call MaxMadatsp}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaxProductCode").trim(),};

                    list.add(model);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getMaxHDDH() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call  MaxHDDH}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaxProductCode").trim(),};

                    list.add(model);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getMaxMaBH() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call MaxMaBH}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaxProductCode").trim(),};

                    list.add(model);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getlayKHDaMua() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call layKHDaMua}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("TenKH").trim(),};

                    list.add(model);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Object[]> getSoLuongDaMua(String MaSP, String MaHD) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call get_total_quantity(?,?)}";
                rs = JdbcHelper.executeQuery(sql, MaSP, MaHD);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt("total_quantity"),};

                    list.add(model);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
        return list;
    }
    
        public List<Object[]> getThongKeTungLoaiSP() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call CountProductQuantityByMonthAndType}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt(1),rs.getString(2),rs.getInt(3)};

                    list.add(model);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
        return list;
    }
  public List<Object[]> getThongKeDoanhThuTungNamTrongTungThang(int nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call dbo.ThongKeDoanhThu(?)}";
                rs = JdbcHelper.executeQuery(sql, nam);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt(1),rs.getInt(2),rs.getString(3)};

                    list.add(model);

                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {

            throw new RuntimeException(ex);
        }
        return list;
    }

}
