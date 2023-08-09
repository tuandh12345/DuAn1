/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.HoaDonDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.DuAn1.Dao.HoaDonDAO;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.HoaDonModel;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class DanhSachMH1 extends javax.swing.JDialog {

    DefaultTableModel tblModel;
    HoaDonDAO daoSP = new HoaDonDAO();
    public static String name1 = "";
    public static int soLuong = 0;
    public static double DonGia = 0;
    public static double tongTien = 0;
    public static String Ten = "";
    public static String ngay = "";
    public static String HinhThuc = "";
    public static double Tienkhach = 0;
    public static double TienCon = 0;

    public static String getNgay() {
        return ngay;
    }

    public static String getTen() {
        return Ten;
    }

    public static void setTen(String Ten) {
        DanhSachMH.Ten = Ten;
    }

    public static void setNgay(String ngay) {
        DanhSachMH.ngay = ngay;
    }

    public static int getSoLuong() {
        return soLuong;
    }

    public static void setSoLuong(int soLuong) {
        DanhSachMH.soLuong = soLuong;
    }

    public static double getDonGia() {
        return DonGia;
    }

    public static void setDonGia(double DonGia) {
        DanhSachMH.DonGia = DonGia;
    }

    public static double getTongTien() {
        return tongTien;
    }

    public static void setTongTien(double tongTien) {
        DanhSachMH.tongTien = tongTien;
    }

    public static String getName1() {
        return name1;
    }

    public static void setName1(String name1) {
        DanhSachMH.name1 = name1;
    }

    public static double getTienkhach() {
        return Tienkhach;
    }

    public static void setTienkhach(double Tienkhach) {
        DanhSachMH.Tienkhach = Tienkhach;
    }

    public static double getTienCon() {
        return TienCon;
    }

    public static void setTienCon(double TienCon) {
        DanhSachMH.TienCon = TienCon;
    }

    public static String getHinhThuc() {
        return HinhThuc;
    }

    public static void setHinhThuc(String HinhThuc) {
        DanhSachMH.HinhThuc = HinhThuc;
    }

    public DanhSachMH1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setIconImage( ShareHelper.APP_ICON);
        filltable();
    }

    void filltable() {
        tblModel = (DefaultTableModel) tblUser.getModel();
        tblModel.setRowCount(0);
        DecimalFormat df = new DecimalFormat("#,##0.##");

        try {
            List<HoaDonModel> list = daoSP.select();
            for (HoaDonModel nv : list) {
                String ThoiGianThem = "";

                if (nv.getNgayXuat() != null) {
                    String dateString = nv.getNgayXuat();
                    Date date0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                    ThoiGianThem = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(date0);
                }
                Object[] row = new Object[]{nv.getMaHD(), nv.getSoluong(), df.format(nv.getDongia()), df.format(nv.getTongtien()), ThoiGianThem, nv.getTenKH(), nv.getHinhThuc(), df.format(nv.getTienKhach()), df.format(nv.getTienCon())};
                tblModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUser = new javaswingdev.swing.table.Table();
        txtTimKiem = new com.DuAn1.Swing.TextField1();
        button2 = new com.DuAn1.Swing.Button();
        jLabel1 = new javax.swing.JLabel();
        cboThoiGian = new com.DuAn1.Swing.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã ĐH", "Số lượng", "Đơn giá", "Tổng tiền", "Thời gian đặt", "Mã Khách Hàng", "Hình thức TT", "Tiền khách đưa", "Tiền thừa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblUser);

        txtTimKiem.setToolTipText("");
        txtTimKiem.setHint("Tìm kiếm");
        txtTimKiem.setName(""); // NOI18N
        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        button2.setText("Tìm kiếm");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách mua hàng");

        cboThoiGian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hôm nay", "Tuấn này", "Tháng này" }));
        cboThoiGian.setSelectedIndex(-1);
        cboThoiGian.setLabeText("Thời gian");
        cboThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThoiGianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(401, 401, 401)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        int chon = tblUser.getSelectedRow();
        String name = (String) tblUser.getValueAt(chon, 0);
        String soLuong = (String) tblUser.getValueAt(chon, 1);
        String gia = (String) tblUser.getValueAt(chon, 2);
        gia = gia.replace(",", "");
        String TongTien = (String) tblUser.getValueAt(chon, 3);
        TongTien = TongTien.replace(",", "");
        String ThoiGian = (String) tblUser.getValueAt(chon, 4);
        String Ten = (String) tblUser.getValueAt(chon, 5);
        String HinhThuc = (String) tblUser.getValueAt(chon, 6);
        String TienKhachDua = (String) tblUser.getValueAt(chon, 7);
        TienKhachDua = TienKhachDua.replace(",", "");
        String TienThua = (String) tblUser.getValueAt(chon, 8);
        TienThua = TienThua.replace(",", "");
        DanhSachMH1.setTongTien(Double.parseDouble(TongTien));
        DanhSachMH1.setSoLuong(Integer.parseInt(soLuong));
        DanhSachMH1.setDonGia(Double.parseDouble(gia));
        DanhSachMH1.setTen(Ten);
        DanhSachMH1.setName1(name);
        DanhSachMH1.setNgay(ThoiGian);
        DanhSachMH1.setHinhThuc(HinhThuc);
        DanhSachMH1.setTienkhach(Double.parseDouble(TienKhachDua));
        DanhSachMH1.setTienCon(Double.parseDouble(TienThua));
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_tblUserMouseClicked

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        tblModel = (DefaultTableModel) tblUser.getModel();
        tblModel.setRowCount(0);
        try {
            List<HoaDonModel> list = daoSP.TimKiem(txtTimKiem.getText());
            for (HoaDonModel nv : list) {
                String ThoiGianThem = "";

                if (nv.getNgayXuat() != null) {
                    String dateString = nv.getNgayXuat();
                    Date date0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                    ThoiGianThem = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(date0);
                }
                Object[] row = new Object[]{nv.getMaHD(), nv.getSoluong(), nv.getDongia(), nv.getTongtien(), ThoiGianThem, nv.getTenKH(), nv.getHinhThuc(), nv.getTienKhach(), nv.getTienCon()};
                tblModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed
DecimalFormat df = new DecimalFormat("#,##0.##");
    private void cboThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThoiGianActionPerformed
        // TODO add your handling code here:
        if (cboThoiGian.getSelectedItem().equals("Hôm nay")) {
            tblModel = (DefaultTableModel) tblUser.getModel();
            tblModel.setRowCount(0);
            try {
                List<HoaDonModel> list = daoSP.selectHomNay();

                    for (HoaDonModel nv : list) {
                String ThoiGianThem = "";

                if (nv.getNgayXuat() != null) {
                    String dateString = nv.getNgayXuat();
                    Date date0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                    ThoiGianThem = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(date0);
                }
                Object[] row = new Object[]{nv.getMaHD(), nv.getSoluong(), df.format(nv.getDongia()), df.format(nv.getTongtien()), ThoiGianThem, nv.getTenKH(), nv.getHinhThuc(), df.format(nv.getTienKhach()), df.format(nv.getTienCon())};
                tblModel.addRow(row);
            }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }else if(cboThoiGian.getSelectedItem().equals("Tuần này")){
            tblModel = (DefaultTableModel) tblUser.getModel();
            tblModel.setRowCount(0);
            try {
                List<HoaDonModel> list = daoSP.selectTuanNay();

                  for (HoaDonModel nv : list) {
                String ThoiGianThem = "";

                if (nv.getNgayXuat() != null) {
                    String dateString = nv.getNgayXuat();
                    Date date0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                    ThoiGianThem = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(date0);
                }
                Object[] row = new Object[]{nv.getMaHD(), nv.getSoluong(), df.format(nv.getDongia()), df.format(nv.getTongtien()), ThoiGianThem, nv.getTenKH(), nv.getHinhThuc(), df.format(nv.getTienKhach()), df.format(nv.getTienCon())};
                tblModel.addRow(row);
            }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }else if(cboThoiGian.getSelectedItem().equals("Tháng này")){
            tblModel = (DefaultTableModel) tblUser.getModel();
            tblModel.setRowCount(0);
            try {
                List<HoaDonModel> list = daoSP.selectThangNay();

                   for (HoaDonModel nv : list) {
                String ThoiGianThem = "";

                if (nv.getNgayXuat() != null) {
                    String dateString = nv.getNgayXuat();
                    Date date0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                    ThoiGianThem = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(date0);
                }
                Object[] row = new Object[]{nv.getMaHD(), nv.getSoluong(), df.format(nv.getDongia()), df.format(nv.getTongtien()), ThoiGianThem, nv.getTenKH(), nv.getHinhThuc(), df.format(nv.getTienKhach()), df.format(nv.getTienCon())};
                tblModel.addRow(row);
            }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }
    }//GEN-LAST:event_cboThoiGianActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DanhSachMH1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachMH1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachMH1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachMH1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DanhSachMH1 dialog = new DanhSachMH1(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Button button2;
    private com.DuAn1.Swing.Combobox cboThoiGian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javaswingdev.swing.table.Table tblUser;
    private com.DuAn1.Swing.TextField1 txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
