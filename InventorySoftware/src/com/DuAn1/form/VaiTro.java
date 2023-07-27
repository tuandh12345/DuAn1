/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Dao.VaiTroDao;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.ThaoTacModel;
import com.DuAn1.Model.VaiTroModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trana
 */
public class VaiTro extends javax.swing.JPanel {

    DefaultTableModel model;
    ThaoTacDAO ThaoTacDao = new ThaoTacDAO();
    VaiTroDao Dao = new VaiTroDao();
    int row = -1;

    /**
     * Creates new form VaiTro
     */
    public VaiTro() {
        initComponents();
        this.row = -1;
        this.tieude();
        this.filltable();
    }

    void tieude() {
        model = new DefaultTableModel();
        String[] name = new String[]{"Mã Vai Trò", "Chức Vụ", "Ghi Chú"};
        model.setColumnIdentifiers(name);
        tblVaiTro.setModel(model);
    }

    void filltable() {
        model = (DefaultTableModel) tblVaiTro.getModel();
        model.setRowCount(0);
        try {
            List<VaiTroModel> list = Dao.select();
            System.out.println(list.size());
            for (VaiTroModel nv : list) {
                Object[] row = new Object[]{nv.getMaVT(), nv.getTenVT(), nv.getGhichu()};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void insert() {
        VaiTroModel nv = getForm();
        try {
            Dao.insert(nv);
            this.filltable();
            this.ClearForm();
            ThaoTacModel model = getFormThem();
            ThaoTacDao.insert(model);
            JOptionPane.showMessageDialog(this, "Thêm Mới thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm mới thất bại!");
            e.printStackTrace();
        }
    }

    void update() {
        VaiTroModel nv = getForm();
        try {
            Dao.update(nv);
            this.filltable();
             ThaoTacModel model = getFormSua();
            ThaoTacDao.insert(model);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật mới thất bại!");

        }
    }

    void delete() {
        VaiTroModel nv = getForm();
        try {
            Dao.delete(nv);
            this.filltable();
            ThaoTacModel model = getFormXoa();
            ThaoTacDao.insert(model);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại!");
        }
    }

    void setForm(VaiTroModel vt) {
        cboMa.setText(vt.getMaVT());
        txtChucVu.setText(vt.getTenVT());
        if (vt.getGhichu()!= null) {
            txtGhichu.setText(vt.getGhichu());
        }
    }

    VaiTroModel getForm() {
        VaiTroModel vt = new VaiTroModel();
        vt.setMaVT(cboMa.getText());
        vt.setTenVT(txtChucVu.getText());
        vt.setGhichu(txtGhichu.getText());
        return vt;
    }

    void ClearForm() {
        cboMa.setText("");
        txtChucVu.setText("");
        txtGhichu.setText("");
    }

    void edit() {
        String manv = (String) tblVaiTro.getValueAt(this.row, 0);
        VaiTroModel nv = Dao.findById(manv);
        this.setForm(nv);
        this.updateStatus();
    }

    void first() {
        this.row = 0;
        this.edit();
    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }

    void next() {
        if (this.row < tblVaiTro.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    void last() {
        this.row = tblVaiTro.getRowCount() - 1;
        this.edit();
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblVaiTro.getRowCount() - 1);
        btnThem.setEnabled(edit);
        btnSua.setEnabled(edit);
        btnSua.setEnabled(edit);
    }
    public ThaoTacModel getFormThem() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(formatted);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Thêm Vai Trò");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormSua() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(formatted);
        cd.setThoiGianXoa(null);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Sửa Vai Trò");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public ThaoTacModel getFormXoa() {
        ThaoTacModel cd = new ThaoTacModel();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        cd.setThoiGianThem(null);
        cd.setThoiGianSua(null);
        cd.setThoiGianXoa(formatted);
        ShareHelper.ThoiGianHoatDong = formatted;
        cd.setThoIGianHoatDong(ShareHelper.ThoiGianHoatDong);
        cd.setBanThaoTac("Xóa Vai Trò");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtChucVu = new textfield.TextField();
        txtGhichu = new textfield.TextField();
        combobox1 = new com.DuAn1.Swing.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVaiTro = new com.raven.swing.table.Table();
        textField11 = new com.DuAn1.Swing.TextField1();
        jPanel1 = new javax.swing.JPanel();
        btnMoi = new com.DuAn1.Swing.Button();
        btnSua = new com.DuAn1.Swing.Button();
        btnThem = new com.DuAn1.Swing.Button();
        btnXoa = new com.DuAn1.Swing.Button();
        cboMa = new textfield.TextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Vai Trò ");

        txtChucVu.setLabelText("Chức Vụ");

        txtGhichu.setLabelText("Ghi chú");
        txtGhichu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhichuActionPerformed(evt);
            }
        });

        combobox1.setLabeText("Lọc ");

        tblVaiTro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVaiTro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblVaiTroMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblVaiTro);

        textField11.setHint("Tìm kiếm");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnMoi.setBackground(new java.awt.Color(153, 153, 255));
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(153, 153, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(153, 153, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 51, 51));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        cboMa.setLabelText("Mã vai trò");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textField11, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(cboMa, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGhichu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGhichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtGhichuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhichuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhichuActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        ClearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblVaiTroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVaiTroMousePressed
        if (evt.getClickCount() == 1) {
            this.row = tblVaiTro.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblVaiTroMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Button btnMoi;
    private com.DuAn1.Swing.Button btnSua;
    private com.DuAn1.Swing.Button btnThem;
    private com.DuAn1.Swing.Button btnXoa;
    private textfield.TextField cboMa;
    private com.DuAn1.Swing.Combobox combobox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table tblVaiTro;
    private com.DuAn1.Swing.TextField1 textField11;
    private textfield.TextField txtChucVu;
    private textfield.TextField txtGhichu;
    // End of variables declaration//GEN-END:variables
}
