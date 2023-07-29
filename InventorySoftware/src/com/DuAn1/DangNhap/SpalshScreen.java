/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DuAn1.DangNhap;

/**
 *
 * @author RoXen
 */
public class SpalshScreen extends javax.swing.JFrame {

    /**
     * Creates new form SpalshScreen
     */
    public SpalshScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        loadingprogress = new javax.swing.JProgressBar();
        loadingnumber = new javax.swing.JLabel();
        loading = new javax.swing.JLabel();
        jLabel_SoftZyd = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loadingprogress.setForeground(new java.awt.Color(169, 224, 49));
        loadingprogress.setBorderPainted(false);
        loadingprogress.setFocusable(false);
        loadingprogress.setRequestFocusEnabled(false);
        loadingprogress.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(loadingprogress, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 470, 820, 40));

        loadingnumber.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        loadingnumber.setForeground(new java.awt.Color(0, 51, 255));
        loadingnumber.setText("99%");
        jPanel1.add(loadingnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, -1, -1));

        loading.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        loading.setForeground(new java.awt.Color(0, 102, 255));
        loading.setText("99%");
        jPanel1.add(loading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, -1));

        jLabel_SoftZyd.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel_SoftZyd.setForeground(new java.awt.Color(0, 102, 204));
        jLabel_SoftZyd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo-removebg-preview (1).png"))); // NOI18N
        jLabel_SoftZyd.setText("TTA MOBILE");
        jPanel1.add(jLabel_SoftZyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 360, 100));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconSwitter-removebg-preview (1).png"))); // NOI18N
        jButton2.setToolTipText("Twitter");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Twitter_32px_2.png"))); // NOI18N
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 28));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconFB-removebg-preview (1).png"))); // NOI18N
        jButton3.setToolTipText("Facebook");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Facebook_32px_7.png"))); // NOI18N
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 11, -1, 28));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconInsta-removebg-preview (1).png"))); // NOI18N
        jButton4.setToolTipText("Instagram");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Instagram_32px_3.png"))); // NOI18N
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 11, -1, 28));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconYTB-removebg-preview (1).png"))); // NOI18N
        jButton6.setToolTipText("YouTube");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_YouTube_32px_1.png"))); // NOI18N
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 11, -1, 28));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconGmail-removebg-preview (1).png"))); // NOI18N
        jButton5.setToolTipText("Email");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Secured_Letter_32px_2.png"))); // NOI18N
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 11, -1, 28));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SpalshScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpalshScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpalshScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpalshScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        SpalshScreen screen = new SpalshScreen();
        screen.setVisible(true);
        try {
            for (int row = 0; row <= 100; row++) {
                Thread.sleep(10);
                screen.loadingnumber.setText(Integer.toString(row) + "%");
                screen.loadingprogress.setValue(row);
                int value = screen.loadingprogress.getValue();
                if (value < 100) {

                    if (value < 10) {
                        screen.loading.setText("Turning on modules...");
                    }
                    if (value == 20) {
                        screen.loading.setText("Loading modules...");
                    }
                    if (value == 50) {
                        screen.loading.setText("Connecting to database...");
                    }
                    if (value == 70) {
                        screen.loading.setText("Connection to successfull...");
                    }
                    if (value == 80) {
                        screen.loading.setText("Launching Application...");
                    }
                    screen.loadingprogress.setValue(value + 1);
                }
                if (row == 100) {
                    NewSignin dn = new NewSignin();
                    dn.setVisible(true);
                    screen.dispose();
                }
            }
        } catch (Exception e) {
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SpalshScreen().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel_SoftZyd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JLabel loading;
    private javax.swing.JLabel loadingnumber;
    private javax.swing.JProgressBar loadingprogress;
    // End of variables declaration//GEN-END:variables
}
