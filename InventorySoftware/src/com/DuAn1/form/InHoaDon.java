/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.HoaDonCTDAO;
import com.DuAn1.Dao.KhachHangDAO;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.HoaDonCTModel;
import com.DuAn1.Model.KhachHangModel;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL E5470
 */
public class InHoaDon extends javax.swing.JDialog {

    /**
     * Creates new form InHoaDon
     */
    HoaDonCTDAO HDCTDao = new HoaDonCTDAO();
    KhachHangDAO daoKH = new KhachHangDAO();

    public InHoaDon(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(ShareHelper.APP_ICON);
        BillHeader();
        bill();
    }

    private void BillHeader() {
        String name = ShareHelper.USER.getHoTen();
        LocalDateTime current = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS dd-MM-yyyy ");
        String formatted = current.format(formatter);
        txtBill.setText("=====================================================================" + "\n"
                + "========================Tên CTY: CTY TNHH TTA MOBILE=======================" + "\n"
                + "                                                      HOÁ ĐƠN ĐIỆN TỬ                                      \n"
                + "Họ và tên nhân viên : " + name + "\n"
                + "Thời gian xuất: " + formatted + "\n"
                + "Địa chỉ: Toà nhà FPT Polytechnic, Đ. Số 22, Thường Thạnh, Cái Răng, Cần Thơ" + "\n"
                + "==============================" + "\n" + ""
                + "Mã khách hàng: " + HoaDon.hoten
                + "\nThông tin sản phẩm\n" + ""
                + "MaHD                      MaSP                     Giá                 Số lượng          Thành tiền"
                + "\n");
    }

    public void bill() {
        KhachHangModel kh = daoKH.findById(HoaDon.hoten);
        List<HoaDonCTModel> list = HDCTDao.selectAll(HoaDon.ma);
        String name = "";
        double gia = 0;
        double soluong = 0;
        double tongTien = 0;
        DecimalFormat df = new DecimalFormat("#,##0.##");

        for (HoaDonCTModel hoaDonCTModel : list) {
            gia += hoaDonCTModel.getGia();
            soluong += hoaDonCTModel.getSoLuong();
            name = name + hoaDonCTModel.getMaHD() + "         " + hoaDonCTModel.getMaSP() + "          " + df.format(hoaDonCTModel.getGia()) + " VND" + "     " + hoaDonCTModel.getSoLuong() + " Chiec" + "           " + df.format(hoaDonCTModel.getThanhTien()) + " VND" + "\n";
            tongTien += hoaDonCTModel.getThanhTien();
        }

//        DefaultTableModel tableModel = new DefaultTableModel();
//        tableModel.addColumn("Mã hóa đơn");
//        tableModel.addColumn("Mã sản phẩm");
//        tableModel.addColumn("Giá");
//        tableModel.addColumn("Số lượng");
//        tableModel.addColumn("Thành tiền");
//
//        for (HoaDonCTModel hoaDonCTModel : list) {
//            tableModel.addRow(new Object[]{
//                hoaDonCTModel.getMaHD(),
//                hoaDonCTModel.getMaSP(),
//                hoaDonCTModel.getGia(),
//                hoaDonCTModel.getSoLuong(),
//                hoaDonCTModel.getThanhTien()
//            });
//        }
//
//       
//        txtBill.setEditable(false);
//        txtBill.append(tableModel.toString());

        tongTien = tongTien - Double.parseDouble(HoaDon.getGiamGia()) / 100;
        txtBill.setText(txtBill.getText() + name);
        txtBill.setText(txtBill.getText() + "\n"
                + "Phần trăm giảm giá: " + HoaDon.getGiamGia()
                + " %\nTổng tiền là:     " + df.format(tongTien) + "   Đồng" + "\n"
                + "Người mua                                                                                                        Người bán\n"
                + "Ghi rõ họ tên                                                                                                  Ghi rõ họ tên\n"
                + "                                                                                                                 \n"
                + "                                                                                                                   \n"
                + kh.getTenKH() + "                                                                                     " + ShareHelper.USER.getHoTen()
                + "\n                                     Cảm ơn quý khách đã mua hàng!                      ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBill = new javax.swing.JTextArea();
        btnInBill = new com.DuAn1.swing0.button0();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtBill.setColumns(20);
        txtBill.setRows(5);
        jScrollPane1.setViewportView(txtBill);

        btnInBill.setBackground(new java.awt.Color(153, 153, 255));
        btnInBill.setText("In hóa đơn");
        btnInBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(251, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInBill, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(385, 385, 385))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInBill, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInBillActionPerformed

        try {
            //        InBill danhSach = new InBill();
            //        danhSach.setVisible(true);

            txtBill.print();
            dispose();
        } catch (PrinterException ex) {
            Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnInBillActionPerformed

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
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InHoaDon dialog = new InHoaDon(new javax.swing.JFrame(), true);
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
    private com.DuAn1.swing0.button0 btnInBill;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea txtBill;
    // End of variables declaration//GEN-END:variables
}
