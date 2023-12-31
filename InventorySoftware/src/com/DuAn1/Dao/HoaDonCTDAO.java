/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.HoaDonCTModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class HoaDonCTDAO {

    public void insert(HoaDonCTModel model) {
        String sql = "Insert into HOADONCT values (?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaSP(),
                model.getSoLuong(),
                model.getMaHD(),
                model.getGia(),
                model.getThanhTien()
        );
    }

    public void update(HoaDonCTModel model) {
        String sql = "update HOADONCT set MaSP =? ,soLuong =? ,Gia=?, ThanhTien =? where MaHD =? ";
        JdbcHelper.executeUpdate(sql,
                model.getMaSP(),
                model.getSoLuong(),
                model.getGia(),
                model.getThanhTien(),
                model.getMaHD()
        );
    }

    public void updateGopSP(HoaDonCTModel model) {
        String sql = "update HOADONCT set soLuong =? , ThanhTien =? where MaHD =? and MaSP =? ";
        JdbcHelper.executeUpdate(sql,
                model.getSoLuong(),
                model.getThanhTien(),
                model.getMaHD(),
                model.getMaSP()
        );
    }

    public List<HoaDonCTModel> selectAll(String MaHDCT) {
        String sql = "SELECT * FROM HOADONCT WHERE MaHD = ?";
        return select(sql, MaHDCT);
    }

    public List<HoaDonCTModel> selectKhDaMuaSp(String MaHDCT) {
        String sql = "SELECT MaHDCT,MaSP,Hoadonct.SoLuong,Hoadonct.MaHD,gia,ThanhTien\n"
                + "FROM HOADON\n"
                + "INNER JOIN HOADONCT\n"
                + "ON HOADON.mahd = HOADONCT.MaHd\n"
                + "WHERE TenKH = ?";
        return select(sql, MaHDCT);
    }

    public void delete(HoaDonCTModel model) {
        String sql = "DELETE HOADONCT WHERE MaHDCT = ?";
        JdbcHelper.executeUpdate(sql, model.getMaHD());
    }

    public void deleteBaoHanh(String mahd, String MaSP) {
        String sql = "DELETE HOADONCT WHERE MaHDCT = ? and MaSP= ?";
        JdbcHelper.executeUpdate(sql, mahd, MaSP);
    }
    public void deleteBaoHanh1(String mahd, String MaSP) {
        String sql = "DELETE HOADONCT WHERE MaSP = ? and MaHD= ?";
        JdbcHelper.executeUpdate(sql, mahd, MaSP);
    }
    public void XoaTatCa(String MaDH,String MaSP) {
        String sql = "DELETE HOADONCT WHERE MaHD = ? and MaSP= ?";
        JdbcHelper.executeUpdate(sql, MaDH,MaSP);
    }

    public List<HoaDonCTModel> select(String sql, Object... args) {
        List<HoaDonCTModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDonCTModel model = readFromResultSet(rs);
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

    private HoaDonCTModel readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonCTModel model = new HoaDonCTModel();
        model.setMaHDCT(rs.getString(1));
        model.setMaSP(rs.getString(2));
        model.setSoLuong(rs.getFloat(3));
        model.setMaHD(rs.getString(4));
        model.setGia(rs.getDouble(5));
        model.setThanhTien(rs.getDouble(6));
        return model;
    }
}
