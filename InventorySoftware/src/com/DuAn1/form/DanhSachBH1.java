/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.BaoHanhDAO;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.BaoHanhModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class DanhSachBH1 extends javax.swing.JDialog {

    DefaultTableModel tblModel;
    BaoHanhDAO dao = new BaoHanhDAO();
    public static String maBH = "";
    public static String maSP = "";
    public static String maKH = "";
    public static String soEmei = "";
    public static String ngayBH = "";
    public static String ngayHH = "";
    public static String ghiChu = "";
       public static String MaSPCu = "";
    public static String MaHDCu = "";

    public static String getMaSPCu() {
        return MaSPCu;
    }

    public static void setMaSPCu(String MaSPCu) {
        DanhSachBH1.MaSPCu = MaSPCu;
    }

    public static String getMaHDCu() {
        return MaHDCu;
    }

    public static void setMaHDCu(String MaHDCu) {
        DanhSachBH1.MaHDCu = MaHDCu;
    }
    
    public static String getMaBH() {
        return maBH;
    }

    public static void setMaBH(String maBH) {
        DanhSachBH1.maBH = maBH;
    }

    public static String getMaSP() {
        return maSP;
    }

    public static void setMaSP(String maSP) {
        DanhSachBH1.maSP = maSP;
    }

    public static String getMaKH() {
        return maKH;
    }

    public static void setMaKH(String maKH) {
        DanhSachBH1.maKH = maKH;
    }

    public static String getSoEmei() {
        return soEmei;
    }

    public static void setSoEmei(String soEmei) {
        DanhSachBH1.soEmei = soEmei;
    }

    public static String getNgayBH() {
        return ngayBH;
    }

    public static void setNgayBH(String ngayBH) {
        DanhSachBH1.ngayBH = ngayBH;
    }

    public static String getNgayHH() {
        return ngayHH;
    }

    public static void setNgayHH(String ngayHH) {
        DanhSachBH1.ngayHH = ngayHH;
    }

    public static String getGhiChu() {
        return ghiChu;
    }

    public static void setGhiChu(String ghiChu) {
        DanhSachBH1.ghiChu = ghiChu;
    }

    /**
     * Creates new form DanhSachBH1
     */
    public DanhSachBH1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        filltable();
        setIconImage(ShareHelper.APP_ICON);
    }

    void filltable() {
        tblModel = (DefaultTableModel) tblUser.getModel();
        tblModel.setRowCount(0);
        try {
            List<BaoHanhModel> list = dao.selectall();
            System.out.println(list.size());
            for (BaoHanhModel nv : list) {
                String formattedDate1 ="";
                 String formattedDate2="";
                if(nv.getNgayBH()!=null){
                String dateString1 = nv.getNgayBH();
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString1);
               formattedDate1 = new SimpleDateFormat("dd-MM-yyyy").format(date1);
                }
                if(nv.getNgayHetHan()!=null){
                String dateString2 = nv.getNgayHetHan();
                Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateString2);
                formattedDate2= new SimpleDateFormat("dd-MM-yyyy").format(date2);
                }
                Object[] row = new Object[]{nv.getMaBH(),
                    nv.getMaHD(),
                    nv.getSoEmei(),
                    formattedDate1,
                    formattedDate2,
                    nv.getGhiChu(),
                    nv.getMaKH(),nv.getMaSPCu(),nv.getMaHDCu()};
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã BH", "Số lượng mới", "Số lượng cũ", "Ngày bảo hành", "Ngày hết hạn", "Ghi Chú", "Mã KH", "Mã sản phẩm cũ", "Mã Hóa đơn cũ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false
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
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        button2.setText("Tìm kiếm");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addGap(62, 62, 62))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(418, Short.MAX_VALUE)))
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
        String maBH = (String) tblUser.getValueAt(chon, 0);
        String maSP = (String) tblUser.getValueAt(chon, 1);
        String soImei = (String) tblUser.getValueAt(chon, 2);
        String soNgayHB = (String) tblUser.getValueAt(chon, 3);
        String NgayHH = (String) tblUser.getValueAt(chon, 4);
        String GhiChu = (String) tblUser.getValueAt(chon, 5);
        String maKH = (String) tblUser.getValueAt(chon, 6);
           String MaSPCu = (String) tblUser.getValueAt(chon, 7);
        String MaHDCu = (String) tblUser.getValueAt(chon, 8);
        DanhSachBH1.setMaBH(maBH);
        DanhSachBH1.setMaSP(maSP);
        DanhSachBH1.setSoEmei(soImei);
        DanhSachBH1.setNgayBH(NgayHH);
        DanhSachBH1.setNgayHH(NgayHH);
        DanhSachBH1.setGhiChu(GhiChu);
        DanhSachBH1.setMaKH(maKH);
        DanhSachBH1.setMaSPCu(MaSPCu);
        DanhSachBH1.setMaHDCu(MaHDCu);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_tblUserMouseClicked

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        tblModel = (DefaultTableModel) tblUser.getModel();
        tblModel.setRowCount(0);
        try {
            List<BaoHanhModel> list = dao.TimKiem(txtTimKiem.getText());
            for (BaoHanhModel nv : list) {
                String ngayBaoHanh = "", ngayHHan = "";
                if (nv.getNgayBH() != null) {
                    String dateString1 = nv.getNgayBH();
                    Date date0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString1);
                    ngayBaoHanh = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(date0);
                }
                if (nv.getNgayHetHan() != null) {
                    String dateString2 = nv.getNgayHetHan();
                    Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString2);
                    ngayHHan = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(date1);
                }
                Object[] row = new Object[]{nv.getMaBH(), nv.getMaHD(), nv.getSoEmei(), ngayBaoHanh, ngayHHan, nv.getGhiChu(), nv.getMaKH()};
                tblModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

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
            java.util.logging.Logger.getLogger(DanhSachBH1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachBH1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachBH1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachBH1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DanhSachBH1 dialog = new DanhSachBH1(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javaswingdev.swing.table.Table tblUser;
    private com.DuAn1.Swing.TextField1 txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
