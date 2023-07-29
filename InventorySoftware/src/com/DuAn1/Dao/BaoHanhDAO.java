/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DuAn1.Dao;

import com.DuAn1.Helper.JdbcHelper;
import com.DuAn1.Model.BaoHanhModel;
import com.DuAn1.Model.DatSPModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trana
 */
public class BaoHanhDAO {
    public void insert(BaoHanhModel model){
        String sql ="Insert into BAOHANH values (?,?,?,?,?,?,?) ";
        com.DuAn1.Helper.JdbcHelper.executeUpdate(sql,model.getMaBH(),model.getMaHD(),model.getSoEmei()
        ,model.getNgayBH(),model.getNgayHetHan(),model.getGhiChu(),model.getMaKH());
    }
    public List<BaoHanhModel> select() {
        String sql = "SELECT * FROM BaoHanh";
        return select(sql);
    }
    public void delete(BaoHanhModel model) {
        String sql = "DELETE BaoHanh WHERE MaBH = ?";
        JdbcHelper.executeUpdate(sql, model.getMaBH());
    }
    private List<BaoHanhModel> select(String sql, Object... args) {
        List<BaoHanhModel> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = com.DuAn1.Helper.JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    BaoHanhModel model = readFromResultSet(rs);
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
    private BaoHanhModel readFromResultSet(ResultSet rs) throws SQLException {
        BaoHanhModel model = new BaoHanhModel();
       model.setMaBH(rs.getString(1));
       model.setMaHD(rs.getString(2));
       model.setSoEmei(rs.getString(3));
       model.setNgayBH(rs.getString(4));
       model.setNgayHetHan(rs.getString(5));
       model.setGhiChu(rs.getString(6));
       model.setMaKH(rs.getString(7));
        return model;
    }
}