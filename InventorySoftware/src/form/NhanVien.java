/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

/**
 *
 * @author DELL E5470
 */
public class NhanVien extends javax.swing.JPanel {

    /**
     * Creates new form NhanVien
     */
    public NhanVien() {
        initComponents();
        txtNgaySinh.setText("1-1-2000");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new com.raven.datechooser.DateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.table.Table();
        txtNgaySinh = new com.tuandhpc05076.Swing.TextField();
        txtNgaySinh1 = new com.tuandhpc05076.Swing.TextField();
        txtNgaySinh2 = new com.tuandhpc05076.Swing.TextField();
        txtNgaySinh3 = new com.tuandhpc05076.Swing.TextField();
        txtNgaySinh4 = new com.tuandhpc05076.Swing.TextField();
        txtNgaySinh5 = new com.tuandhpc05076.Swing.TextField();
        combobox1 = new com.tuandhpc05076.Swing.Combobox();
        combobox2 = new com.tuandhpc05076.Swing.Combobox();
        txtNgaySinh6 = new com.tuandhpc05076.Swing.TextField();
        txtNgaySinh7 = new com.tuandhpc05076.Swing.TextField();
        txtNgaySinh8 = new com.tuandhpc05076.Swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        switchButton1 = new com.tuandhpc05076.swing0.SwitchButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        imageAvatar1 = new com.tuandhpc05076.swing0.ImageAvatar();

        dateChooser.setTextRefernce(txtNgaySinh);

        setBackground(new java.awt.Color(255, 255, 255));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"dsfsdf", "dsfsd", "sdfds", "sdfs"},
                {"sdf", "sdfs", "sdf", "sdf"},
                {"dsf", "sdf", "sdf", null},
                {null, null, null, null}
            },
            new String [] {
                "sdfsdf", "sdfds", "Title 3sdfsdf", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table1);

        txtNgaySinh.setLabelText("Ngày sinh");
        txtNgaySinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaySinhMouseClicked(evt);
            }
        });
        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });

        txtNgaySinh1.setLabelText("Mật khẩu");
        txtNgaySinh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaySinh1MouseClicked(evt);
            }
        });

        txtNgaySinh2.setLabelText("Mã nhân viên ");
        txtNgaySinh2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaySinh2MouseClicked(evt);
            }
        });

        txtNgaySinh3.setLabelText("Email");
        txtNgaySinh3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaySinh3MouseClicked(evt);
            }
        });

        txtNgaySinh4.setLabelText("Địa chỉ");
        txtNgaySinh4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaySinh4MouseClicked(evt);
            }
        });

        txtNgaySinh5.setLabelText("Tài khoản");
        txtNgaySinh5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaySinh5MouseClicked(evt);
            }
        });

        combobox1.setLabeText("Vai trò");

        combobox2.setLabeText("Giới tính");
        combobox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox2ActionPerformed(evt);
            }
        });

        txtNgaySinh6.setLabelText("Họ tên");
        txtNgaySinh6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaySinh6MouseClicked(evt);
            }
        });

        txtNgaySinh7.setLabelText("Mô tả");
        txtNgaySinh7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaySinh7MouseClicked(evt);
            }
        });

        txtNgaySinh8.setLabelText("Số điện thoại");
        txtNgaySinh8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaySinh8MouseClicked(evt);
            }
        });

        jLabel1.setText("Trạng thái:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 51));
        jLabel2.setText("Đang hoạt động");

        jButton1.setText("Tải hình ảnh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh5, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNgaySinh7, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNgaySinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNgaySinh6, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNgaySinh8, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNgaySinh4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNgaySinh3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaySinh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaySinh4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNgaySinh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgaySinh7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(switchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgaySinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaySinhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhMouseClicked

    private void txtNgaySinh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaySinh1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinh1MouseClicked

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void txtNgaySinh2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaySinh2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinh2MouseClicked

    private void txtNgaySinh3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaySinh3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinh3MouseClicked

    private void txtNgaySinh4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaySinh4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinh4MouseClicked

    private void txtNgaySinh5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaySinh5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinh5MouseClicked

    private void combobox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox2ActionPerformed

    private void txtNgaySinh6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaySinh6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinh6MouseClicked

    private void txtNgaySinh7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaySinh7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinh7MouseClicked

    private void txtNgaySinh8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaySinh8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinh8MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.tuandhpc05076.Swing.Combobox combobox1;
    private com.tuandhpc05076.Swing.Combobox combobox2;
    private com.raven.datechooser.DateChooser dateChooser;
    private com.tuandhpc05076.swing0.ImageAvatar imageAvatar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.tuandhpc05076.swing0.SwitchButton switchButton1;
    private com.raven.swing.table.Table table1;
    private com.tuandhpc05076.Swing.TextField txtNgaySinh;
    private com.tuandhpc05076.Swing.TextField txtNgaySinh1;
    private com.tuandhpc05076.Swing.TextField txtNgaySinh2;
    private com.tuandhpc05076.Swing.TextField txtNgaySinh3;
    private com.tuandhpc05076.Swing.TextField txtNgaySinh4;
    private com.tuandhpc05076.Swing.TextField txtNgaySinh5;
    private com.tuandhpc05076.Swing.TextField txtNgaySinh6;
    private com.tuandhpc05076.Swing.TextField txtNgaySinh7;
    private com.tuandhpc05076.Swing.TextField txtNgaySinh8;
    // End of variables declaration//GEN-END:variables
}
