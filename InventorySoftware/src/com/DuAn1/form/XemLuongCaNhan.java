/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.ThanhToanLuongDAO;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.ThanhToanLuongModel;
import com.tuandhpc05076.helper.DialogHelper;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoang Tuan
 */
public class XemLuongCaNhan extends javax.swing.JDialog {

    /**
     * Creates new form XemLuongCaNhan
     */
    public XemLuongCaNhan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(ShareHelper.APP_ICON);
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
        cboVaitro = new com.DuAn1.Swing.Combobox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThanhToanLuong = new com.raven.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JLabel();
        cboVaitro1 = new com.DuAn1.Swing.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cboVaitro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
        cboVaitro.setSelectedIndex(-1);
        cboVaitro.setLabeText("Chon thang");
        cboVaitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboVaitroActionPerformed(evt);
            }
        });

        tblThanhToanLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhan vien", "Số ngày làm ", "Lương cơ bản", "Ngày thanh toan", "Số giờ tăng ca ", "Lương tăng ca ", "Khoảng trừ", "Tổng tiền ", "Trạng thái "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThanhToanLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThanhToanLuongMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblThanhToanLuongMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblThanhToanLuong);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tong tien:");

        txtLuong.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtLuong.setForeground(new java.awt.Color(255, 51, 51));
        txtLuong.setText("0");

        cboVaitro1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2021", "2022", "2023" }));
        cboVaitro1.setSelectedIndex(-1);
        cboVaitro1.setLabeText("Chon nam");
        cboVaitro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboVaitro1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboVaitro1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cboVaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addComponent(txtLuong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboVaitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboVaitro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLuong))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    ThaoTacDAO thaotacdao = new ThaoTacDAO();
    ThanhToanLuongDAO dao = new ThanhToanLuongDAO();
    int row = -1;
    DefaultTableModel model;
    private void cboVaitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboVaitroActionPerformed
        // TODO add your handling code here:
        if(cboVaitro1.getSelectedItem()==null){
            DialogHelper.alert(this,"Ban chua chon nam");
            return;
        }
        String LayThang = (String) cboVaitro.getSelectedItem();
        String so = LayThang.replace("Tháng", "");
        String layNam = (String) cboVaitro1.getSelectedItem();
        model = (DefaultTableModel) tblThanhToanLuong.getModel();
        model.setRowCount(0);
        DecimalFormat df = new DecimalFormat("#,##0.##");
        try {
            List<ThanhToanLuongModel> list = dao.XemThanhToanLuongCaNhan(Integer.parseInt(so.trim()),Integer.parseInt(layNam), ShareHelper.USER.getMaNV().trim());
            if (list.size() > 0) {
                for (ThanhToanLuongModel ttl : list) {
                    String dateString = ttl.getNgayVaoCTy();
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                    String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
                    Object[] rows = {ttl.getMaLuong(), ttl.getSoNgayLam(), df.format(ttl.getLuongCoBan()) + " VND",
                        formattedDate,
                        ttl.getSoGioTangCa()+" Gio",
                        df.format(ttl.getLuongTangCa())+" VND", df.format(ttl.getKhoanTru()) + " VND", df.format(ttl.getTongTien()) + " VND", ttl.isTrangThai()? "Ðã thanh toan":"Ðang cho cap nhat"};
                    model.addRow(rows);
                }
                String Luong = (String) tblThanhToanLuong.getValueAt(0, 7);
                if (Luong != null) {
                    txtLuong.setText(Luong);
                }
            }else{
                com.DuAn1.Helper.DialogHelper.alert(this, "Chua co luong trong thang nay");
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }


    }//GEN-LAST:event_cboVaitroActionPerformed

    private void tblThanhToanLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThanhToanLuongMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblThanhToanLuongMouseClicked

    private void tblThanhToanLuongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThanhToanLuongMousePressed
        //         TODO add your handling code here:
        //        if (evt.getClickCount() == 1) {
        //            this.row = tblThanhToanLuong.getSelectedRow();
        //            this.edit();
        //        }
    }//GEN-LAST:event_tblThanhToanLuongMousePressed

    private void cboVaitro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboVaitro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboVaitro1ActionPerformed

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
            java.util.logging.Logger.getLogger(XemLuongCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XemLuongCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XemLuongCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XemLuongCaNhan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                XemLuongCaNhan dialog = new XemLuongCaNhan(new javax.swing.JFrame(), true);
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
    private com.DuAn1.Swing.Combobox cboVaitro;
    private com.DuAn1.Swing.Combobox cboVaitro1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table tblThanhToanLuong;
    private javax.swing.JLabel txtLuong;
    // End of variables declaration//GEN-END:variables
}
