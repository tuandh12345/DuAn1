package com.raven.form;

import com.DuAn1.Dao.DatSPDAO;
import com.DuAn1.main.Main;
import com.raven.dialog.Message;

import com.raven.model.ModelCard;
import com.raven.model.ModelStudent;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.table.EventAction;
import com.tuandhpc05076.Dao.NhanVienDAO;
import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Dao.SanPhamDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Helper.DialogHelper;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.Model.DatSPModel;
import com.DuAn1.Model.NhanVienModel;
import java.awt.Color;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.DuAn1.tabledark.Test;
import com.DuAn1.test.Slide1;
import com.DuAn1.test.Slide2;
import com.DuAn1.test.Slide3;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Form_Home extends javax.swing.JPanel {

    NhanVienDAO1 dao = new NhanVienDAO1();
    ThongKeDao DaoThongKe = new ThongKeDao();
    DatSPDAO daoDatSP = new DatSPDAO();

    public Form_Home() {
        initComponents();

        slideshow1.initSlideshow(new Slide1(), new Slide2(), new Slide3());
        tblUser.fixTable(jScrollPane1);
        setOpaque(false);
        tblUser.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblUser.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblUser.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblUser.getColumnModel().getColumn(3).setPreferredWidth(70);
        tblUser.getColumnModel().getColumn(4).setPreferredWidth(0);
        initData();

    }

    private void initData() {
        initCardData();
        initNoticeBoard();
        fillTable();
//        initTableData();
    }

    void fillTable() {
        DefaultTableModel model1 = (DefaultTableModel) tblUser.getModel();
        model1.setRowCount(0);
        try {
            List<NhanVienModel> list = dao.selectHoatDong();
            for (NhanVienModel model : list) {
                String gt = "";
                if (model.isGioiTinh()) {
                    gt = "Nam";
                } else {
                    gt = "Nữ";
                }
                String vaiTro = "";
                if (model.getVaiTro().trim().equals("QL")) {
                    vaiTro = "Quản lý";
                } else {
                    vaiTro = "Nhân viên";
                }
                String dateString = model.getNgaySinh();
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);

                Object[] row = {
                    model.getMaNV(),
                    model.getHoTen(),
                    formattedDate,
                    gt,
                    vaiTro,
                    model.getDiaChi(),
                    model.getSDT(),
                    model.getEmail(),
                    model.getMatKhau(),
                    model.getHinh()
                };

                model1.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

//    private void initTableData() {
//        EventAction eventAction = new EventAction() {
//            @Override
//            public void delete(ModelStudent student) {
//                if (showMessage("Delete Student : " + student.getName())) {
//                    System.out.println("Delete click OK");
//                    Test n = new Test();
//                    n.setVisible(true);
//                } else {
//                    System.out.println("Delete click Cancel");
//                }
//            }
//
//            @Override
//            public void update(ModelStudent student) {
//                if (showMessage("Update Student : " + student.getName())) {
//                    System.out.println("Update click OK");
//                } else {
//                    System.out.println("Update click Cancel");
//                }
//            }
//        };
//        tblUser.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile.jpg")), "Tuấn", "Nam", "Java", 200).toRowTable(eventAction));
//        tblUser.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile1.jpg")), "Bình", "Nam", "C++", 300).toRowTable(eventAction));
//        tblUser.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "An", "Nữ", "C#", 400).toRowTable(eventAction));
//        tblUser.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Thành", "Nam", "C#", 600).toRowTable(eventAction));
//        tblUser.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bảo", "Nam", "C#", 800).toRowTable(eventAction));
//        tblUser.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Lê", "Nữ", "C#", 400).toRowTable(eventAction));
//        tblUser.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Ngọc", "Nữ", "C#", 100).toRowTable(eventAction));
//        tblUser.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Anh", "Nữ", "C#", 600).toRowTable(eventAction));
//        tblUser.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Vũ", "Nam", "C#", 400).toRowTable(eventAction));
//        tblUser.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Đại", "Đại", "C#", 300).toRowTable(eventAction));
//        tblUser.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Hoa", "Nữ", "C#", 100).toRowTable(eventAction));
//        tblUser.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Trân", "Nữ", "C#", 300).toRowTable(eventAction));
//        tblUser.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Yến", "Nữ", "C#", 700).toRowTable(eventAction));
//    }
    SanPhamDAO daoSoLuong = new SanPhamDAO();

    private void initCardData() {
        double tong = 0;
        double Thang1 = 0;
        List<Object[]> i = daoSoLuong.getSoLuongSP();
        int tongSoLuong = Arrays.stream(i.get(0))
                .mapToInt(obj -> (int) obj)
                .sum();
        List<Object[]> daoThongKe1 = DaoThongKe.getThongKeDoanhThuTungNamTrongTungThang(2023);
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String formatted = current.format(formatter);
        for (Object[] objects : daoThongKe1) {
            if (objects[1].equals(Integer.parseInt(formatted))) {
                Thang1 = Double.parseDouble(objects[2].toString());
                break;
            } 
        }

//        List<Object[]> j = DaoThongKe.DoanhThuThang();
//        String name = (String) j.get(3)[1];
//        for (Object[] row : j) {
//            String name1 = (String) row[1];
//            tong += Double.parseDouble(name);
//        }
        List<NhanVienModel> list = dao.select();
        List<DatSPModel> sp = daoDatSP.select();
        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card1.setData(new ModelCard("Số lượng sản phẩm", tongSoLuong, 20, icon1));
        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
           if (ShareHelper.USER.getVaiTro().trim().equals("QL")) {
        card2.setData(new ModelCard("Doanh thu tháng", Thang1, 60, icon2));
           }else{
               card2.setData(new ModelCard("Doanh thu tháng",0, 60, icon2));
           }
        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SHOPPING_BASKET, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card3.setData(new ModelCard("Nhân viên", list.size(), 80, icon3));
        Icon icon4 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BUSINESS_CENTER, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card4.setData(new ModelCard("Số lượng đặt hàng", sp.size(), 95, icon4));
    }

    private void initNoticeBoard() {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formatted = current.format(formatter);
        noticeBoard.addDate(formatted);
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), "IPhone", "Mới đăng", "Dòng iPhone là dòng điện thoại thông minh cao cấp được sản xuất bởi Apple Inc. Dòng iPhone ra mắt lần đầu tiên vào năm 2007 và đã trở thành một trong những dòng điện thoại thông minh phổ biến nhất thế giới. iPhone được biết đến với thiết kế đẹp, hiệu suất mạnh mẽ và hệ sinh thái ứng dụng phong phú.\n"
                + "\n"
                + "Dòng iPhone hiện có nhiều mẫu mã khác nhau, từ iPhone SE giá rẻ đến iPhone 13 Pro Max cao cấp. Mỗi mẫu iPhone đều có những ưu điểm và nhược điểm riêng, phù hợp với nhu cầu của từng người dùng.\n"
                + "\n"
                + "Dưới đây là một số điểm nổi bật của dòng iPhone:\n"
                + "\n"
                + "Thiết kế đẹp, sang trọng\n"
                + "Hiệu suất mạnh mẽ\n"
                + "Hệ sinh thái ứng dụng phong phú\n"
                + "Camera chất lượng cao\n"
                + "Thời lượng pin lâu\n"
                + "Bảo mật tuyệt vời\n"
                + "Dòng iPhone là một lựa chọn tuyệt vời cho những người dùng đang tìm kiếm một chiếc điện thoại thông minh cao cấp, đa năng và có nhiều tính năng. Nếu bạn đang tìm kiếm một chiếc điện thoại thông minh tốt nhất trên thị trường, thì iPhone là một lựa chọn không thể bỏ qua."));
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(218, 49, 238), "Samsung", "Mới đăng", "Sony là một tập đoàn đa quốc gia của Nhật Bản chuyên sản xuất các sản phẩm điện tử, giải trí và công nghệ cao. Sony được thành lập vào năm 1946 và hiện là một trong những tập đoàn lớn nhất thế giới.\n"
                + "\n"
                + "Sony có nhiều sản phẩm nổi tiếng, bao gồm:\n"
                + "\n"
                + "Điện thoại thông minh Xperia\n"
                + "Máy ảnh Alpha\n"
                + "Loa không dây SRS-XB43\n"
                + "TV BRAVIA XR\n"
                + "PlayStation 5\n"
                + "Vaio Laptop\n"
                + "Walkman\n"
                + "Sony được biết đến với chất lượng cao, thiết kế đẹp và tính năng tiên tiến. Các sản phẩm của Sony được bán trên toàn thế giới và được nhiều người dùng tin tưởng.\n"
                + "\n"
                + "Dưới đây là một số điểm nổi bật của Sony:\n"
                + "\n"
                + "Chất lượng cao\n"
                + "Thiết kế đẹp\n"
                + "Tính năng tiên tiến\n"
                + "Giá cả phải chăng\n"
                + "Đa dạng sản phẩm\n"
                + "Sony là một thương hiệu đáng tin cậy và được nhiều người dùng trên thế giới tin tưởng. Nếu bạn đang tìm kiếm một sản phẩm điện tử, giải trí hoặc công nghệ cao chất lượng cao, thì Sony là một thương hiệu đáng xem xét"));
        noticeBoard.addDate(formatted);
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Samsung", "Mới đăng", "Samsung là một tập đoàn đa quốc gia của Hàn Quốc chuyên sản xuất các sản phẩm điện tử tiêu dùng, điện tử công nghiệp, thiết bị gia dụng và dịch vụ. Samsung được thành lập vào năm 1938 bởi Lee Byung-chul và hiện là một trong những tập đoàn lớn nhất thế giới."));

        noticeBoard.scrollToTop();
    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card1 = new com.DuAn1.component.Card();
        jLabel1 = new javax.swing.JLabel();
        card2 = new com.DuAn1.component.Card();
        card3 = new com.DuAn1.component.Card();
        card4 = new com.DuAn1.component.Card();
        jPanel1 = new javax.swing.JPanel();
        noticeBoard = new com.raven.swing.noticeboard.NoticeBoard();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        slideshow1 = new slideshow.Slideshow();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new com.raven.swing.table.Table();

        card1.setColorGradient(new java.awt.Color(211, 28, 215));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Home");

        card2.setBackground(new java.awt.Color(10, 30, 214));
        card2.setColorGradient(new java.awt.Color(72, 111, 252));

        card3.setBackground(new java.awt.Color(194, 85, 1));
        card3.setColorGradient(new java.awt.Color(255, 212, 99));

        card4.setBackground(new java.awt.Color(60, 195, 0));
        card4.setColorGradient(new java.awt.Color(208, 255, 90));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(noticeBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 233, 411, 200));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 76, 76));
        jLabel2.setText("Thông tin mới nhất");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 70, 411, 1));
        jPanel1.add(slideshow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 420, 200));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Nhân viên đang hoạt động");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ và tên", "Ngày sinh", "Giới tính", "Vai trò"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        jScrollPane1.setViewportView(tblUser);
        if (tblUser.getColumnModel().getColumnCount() > 0) {
            tblUser.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblUserMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.component.Card card1;
    private com.DuAn1.component.Card card2;
    private com.DuAn1.component.Card card3;
    private com.DuAn1.component.Card card4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.noticeboard.NoticeBoard noticeBoard;
    private slideshow.Slideshow slideshow1;
    private com.raven.swing.table.Table tblUser;
    // End of variables declaration//GEN-END:variables
}
