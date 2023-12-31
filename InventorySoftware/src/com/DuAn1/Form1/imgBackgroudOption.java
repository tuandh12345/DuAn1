/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.Form1;

import com.DuAn1.swing0.EventSwitchSelected;
import com.DuAn1.swing0.SwitchButton;
import com.DuAn1.swing0.SystemProperties;
import com.DuAn1.swing0.ThemeColorChange;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author DELL E5470
 */
public class imgBackgroudOption extends javax.swing.JPanel {

    private MigLayout layout;

    public imgBackgroudOption() {
        initComponents();
        layout = new MigLayout("fill, wrap 1, inset 0", "[fill]", "[]0[0!]");
        setLayout(layout);
        switchButton.addEventSelected(new EventSwitchSelected() {
            @Override
            public void onSelected(boolean selected) {
                if (!selected) {
                    ThemeColorChange.getInstance().changeBackgroundImage("");
//                    new SystemProperties().save("background_image", "");
                }
            }
        });
        switchButton.getAnimator().addTarget(new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double size;
                if (switchButton.isSelected()) {
                    size = (1f - fraction) * 68;
                } else {
                    size = fraction * 68;
                }
                layout.setRowConstraints("[]0[" + size + "!]");
                revalidate();
            }

            @Override
            public void end() {
                if (!switchButton.isSelected()) {
                    clearSelected();
                }
            }
        });
        addEvent();
    }

    public SwitchButton getSwitch() {
        return switchButton;
    }

    public void changeColorLabel(Color color) {
        lbBack.setForeground(color);
    }

    private void addEvent() {
        int image = 1;
        for (Component com : panel.getComponents()) {
            JButton cmd = (JButton) com;
            cmd.setName("bg_" + image++ +".jpg");
            cmd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    clearSelected();
                    cmd.setSelected(true);
                    System.out.println(cmd.getName());
                    ThemeColorChange.getInstance().changeBackgroundImage(cmd.getName());
//                    new SystemProperties().save("background_image", cmd.getName());
                }
            });
        }
    }

    private void clearSelected() {
        for (Component com : panel.getComponents()) {
            JButton cmd = (JButton) com;
            cmd.setSelected(false);
        }
    }

    public void init(String imageSelected) {
        setSelected(imageSelected);
        if (!imageSelected.equals("")) {
            switchButton.setSelected(true);
            layout.setRowConstraints("[]0[68!]");
            revalidate();
        }
    }

    public void setSelected(String imageSelected) {
        clearSelected();
        for (Component com : panel.getComponents()) {
            JButton cmd = (JButton) com;
            if (cmd.getName().equals(imageSelected)) {
                cmd.setSelected(true);
                break;
            }
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        panel = new javax.swing.JPanel();
        buttomImage1 = new com.DuAn1.swing0.ButtomImage();
        buttomImage2 = new com.DuAn1.swing0.ButtomImage();
        buttomImage3 = new com.DuAn1.swing0.ButtomImage();
        buttomImage4 = new com.DuAn1.swing0.ButtomImage();
        buttomImage5 = new com.DuAn1.swing0.ButtomImage();
        jPanel1 = new javax.swing.JPanel();
        lbBack = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        switchButton = new com.DuAn1.swing0.SwitchButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setOpaque(false);

        panel.setOpaque(false);

        buttomImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tuandhpc05076/Image/bg_2_small.jpg"))); // NOI18N

        buttomImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tuandhpc05076/Image/bg_3_small.jpg"))); // NOI18N

        buttomImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tuandhpc05076/Image/bg_4_small.jpg"))); // NOI18N

        buttomImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tuandhpc05076/Image/bg_5_small.jpg"))); // NOI18N

        buttomImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tuandhpc05076/Image/bg_1_small.jpg"))); // NOI18N
        buttomImage5.setSelected(true);
        buttomImage5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttomImage5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(buttomImage5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttomImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttomImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(buttomImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(buttomImage4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttomImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttomImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttomImage5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttomImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttomImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel1.setOpaque(false);

        lbBack.setBackground(new java.awt.Color(230, 230, 230));
        lbBack.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbBack.setForeground(new java.awt.Color(230, 230, 230));
        lbBack.setText("Chọn ảnh nền");

        jPanel5.setOpaque(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(switchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(switchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lbBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 699, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBack))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttomImage5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomImage5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttomImage5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.swing0.ButtomImage buttomImage1;
    private com.DuAn1.swing0.ButtomImage buttomImage2;
    private com.DuAn1.swing0.ButtomImage buttomImage3;
    private com.DuAn1.swing0.ButtomImage buttomImage4;
    private com.DuAn1.swing0.ButtomImage buttomImage5;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbBack;
    private javax.swing.JPanel panel;
    private com.DuAn1.swing0.SwitchButton switchButton;
    // End of variables declaration//GEN-END:variables
}
