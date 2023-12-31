/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.DuAn1.form;

import com.DuAn1.Dao.NhanVienDAO1;
import com.DuAn1.Dao.ThaoTacDAO;
import com.DuAn1.Dao.ThongKeDao;
import com.DuAn1.Dao.VaiTroDao;
import com.DuAn1.Helper.DialogHelper;
import com.DuAn1.Helper.ShareHelper;
import com.DuAn1.MaHoa.MaHoa;
import com.DuAn1.Model.NhanVienModel;
import com.DuAn1.Model.ThaoTacModel;
import com.DuAn1.Model.VaiTroModel;
import com.tuandhpc05076.Form.ChuyenDe;
import com.tuandhpc05076.helper.DateHelper;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author DELL E5470
 */
public class NhanVien extends javax.swing.JPanel {

    ThongKeDao DaoThongKe = new ThongKeDao();
    ThaoTacDAO ThaoTacDao = new ThaoTacDAO();
    MaHoa MH = new MaHoa();
    DefaultTableModel model;
    NhanVienDAO1 Dao = new NhanVienDAO1();
    VaiTroDao Daovt = new VaiTroDao();

    int row = -1;
    String so = "0\\d{9,10}";

    /**
     * Creates new form NhanVien
     */
    public NhanVien() {
        initComponents();
        txtNgaysinh.setText("1-1-2000");
        this.row = -1;
        this.tieude();
        this.filltable();
        TuDongTangMa();
        LoadCombobox();
    }

    void LoadCombobox() {
        DefaultComboBoxModel comboboxmodel = new DefaultComboBoxModel();
        VaiTroDao vtDao = new VaiTroDao();
        ArrayList<VaiTroModel> listVaitro = (ArrayList<VaiTroModel>) vtDao.select();
        for (VaiTroModel gg : listVaitro) {
            comboboxmodel.addElement(gg.getTenVT().trim());
        }
        cboVaitro.setModel(comboboxmodel);
        cboVaitro.setSelectedIndex(-1);
    }

    void TuDongTangMa() {
        List<Object[]> i = DaoThongKe.getSoLuongNV();
        String name = (String) i.get(0)[0];
        String[] tbl = name.split("V");
        String so = String.valueOf(Integer.parseInt(tbl[1]) + 1);
        String ten = "NV";
        for (int j = 0; j <= 2 - so.length(); j++) {
            ten += "0";
        }
        ten = ten + so;
        txtTaikhoan.setText(ten);
    }

    void tieude() {
        model = new DefaultTableModel();
        String[] name = new String[]{"Mã Nhân Viên", "Họ Tên", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Số Điện Thoại", "Mã Vai Trò", "Hình", "Trạng Thái"};
        model.setColumnIdentifiers(name);
        tblNhanvien.setModel(model);
    }

    void filltable() {
        model = (DefaultTableModel) tblNhanvien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVienModel> list = Dao.select();
            System.out.println(list.size());
            for (NhanVienModel nv : list) {
                String dateString = nv.getNgaySinh();
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
                String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
                Object[] row = new Object[]{nv.getMaNV(), nv.getHoTen(), formattedDate, nv.isGioiTinh() ? "Nam" : "Nữ",
                    nv.getDiaChi(), nv.getSDT(), nv.getVaiTro(), nv.getHinh(), nv.isTrangThai() ? "Đang hoạt động" : "Không hoạt động"};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void insert() {
        NhanVienModel nv = getForm();
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
        NhanVienModel nv = getForm();
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
        NhanVienModel nv = getForm();
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

    NhanVienModel getForm() {
        NhanVienModel nv = new NhanVienModel();
        nv.setMaNV(txtTaikhoan.getText());
        nv.setHoTen(txtHoten.getText());
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgaysinh.getText());

            String ngayNhap = new SimpleDateFormat("yyyy-MM-dd").format(date);

            nv.setNgaySinh(ngayNhap);

        } catch (Exception e) {
        }
        if (cboGioitinh.getSelectedItem().equals("Nam")) {
            nv.setGioiTinh(true);
        } else {
            nv.setGioiTinh(false);
        }
        String mk = MH.toSHA(new String(txtMatkhau.getPassword()));
        String matKhau = new String(mk);
        nv.setMatKhau(matKhau);
        nv.setDiaChi(txtDiachi.getText());
        nv.setSDT(txtSdt.getText());
        nv.setEmail(txtEmail.getText());
        List<VaiTroModel> list = Daovt.select();
        for (VaiTroModel vt : list) {
            if (cboVaitro.getSelectedItem().equals(vt.getTenVT().trim())) {
                nv.setVaiTro(vt.getMaVT());
                break;
            }
        }
//        if (cboVaitro.getSelectedItem().equals("Quản lý")) {
//            nv.setVaiTro("QL");
//        } else {
//            nv.setVaiTro("NV");
//        }
        nv.setHinh(txtHinhAnh1.getToolTipText() + nv.getMaNV().trim());
        nv.setTrangThai(true);
        if (btnTrangthai.isSelected()) {
            nv.setTrangThai(true);
        } else {
            nv.setTrangThai(false);
        }
        nv.setTrangThaiXoa(true);
        return nv;
    }

    public void btnInDanhSach() {
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();

            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Nhân viên");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblNhanvien.getColumnCount(); i++) {
                    org.apache.poi.ss.usermodel.Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblNhanvien.getColumnName(i));
                }

                for (int j = 0; j < tblNhanvien.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblNhanvien.getColumnCount(); k++) {
                        org.apache.poi.ss.usermodel.Cell cell = row.createCell(k);
                        if (tblNhanvien.getValueAt(j, k) != null) {
                            cell.setCellValue(tblNhanvien.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                OpenFile(saveFile.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException io) {
            System.out.println(io);
        }
    }

    public void OpenFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (Exception e) {
        }
    }

    void setForm(NhanVienModel nv) {
        txtTaikhoan.setText(nv.getMaNV());
        txtHoten.setText(nv.getHoTen());
        try {
            String dateString = nv.getNgaySinh();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
            txtNgaysinh.setText(formattedDate);
        } catch (ParseException ex) {
            Logger.getLogger(SanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        cboGioitinh.setSelectedItem(nv.isGioiTinh() ? "Nam" : "Nữ");
        txtDiachi.setText(nv.getDiaChi());
        txtSdt.setText(nv.getSDT().trim());
        txtEmail.setText(nv.getEmail());
        txtMatkhau.setText("******");
        List<VaiTroModel> list = Daovt.select();
        for (VaiTroModel vt : list) {
            if (nv.getVaiTro().trim().equalsIgnoreCase(vt.getMaVT().trim())) {
                cboVaitro.setSelectedItem(vt.getTenVT());
                break;
            }
        }
//        if (nv.getVaiTro().trim().equalsIgnoreCase("QL")) {
//            cboVaitro.setSelectedItem("Quản lý");
//        } else {
//            cboVaitro.setSelectedItem("Nhân Viên");
//        }
        if (nv.getHinh() != null) {
            String TenHinh = nv.getHinh().trim();
            TenHinh = TenHinh.replace(nv.getMaNV().trim(), "");
            txtHinhAnh1.setToolTipText(TenHinh);
            txtHinhAnh1.setIcon(ShareHelper.readLogo(TenHinh));
            txtHinhAnh1.setToolTipText(TenHinh);
            ImageIcon originalIcon = ShareHelper.readLogo(TenHinh);
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(txtHinhAnh1.getWidth(), txtHinhAnh1.getHeight(), Image.SCALE_SMOOTH);
            txtHinhAnh1.setIcon(new ImageIcon(scaledImage));
        }

        if (nv.isTrangThai()) {
            btnTrangthai.setSelectedAnimate(true);
            txtTrangthai.setText("Đang hoạt động");
        } else {
            btnTrangthai.setSelectedAnimate(false);
            txtTrangthai.setText("Không hoạt động");
        }
    }

    void ClearForm() {
        btnThem.setEnabled(true);
        txtTaikhoan.setText("");
        txtHoten.setText("");
        txtNgaysinh.setText("");
        cboGioitinh.setSelectedItem("Nam");
        txtDiachi.setText("");
        txtSdt.setText("");
        txtEmail.setText("");
        txtMatkhau.setText("");
        cboVaitro.setSelectedItem("Quản Lý");
        txtHinhAnh1.setToolTipText("");
        txtHinhAnh1.setIcon(ShareHelper.readLogo(""));
    }

    void edit() {
        String manv = (String) tblNhanvien.getValueAt(this.row, 0);
        NhanVienModel nv = Dao.findById(manv);
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
        if (this.row < tblNhanvien.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    void last() {
        this.row = tblNhanvien.getRowCount() - 1;
        this.edit();
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblNhanvien.getRowCount() - 1);
        txtTaikhoan.setEditable(!edit);
        txtMatkhau.setEditable(!edit);
        btnThem.setEnabled(edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
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
        cd.setBanThaoTac("Thêm Nhân Viên");
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
        cd.setBanThaoTac("Sửa Nhân Viên");
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
        cd.setBanThaoTac("Xóa Nhân Viên");
        cd.setMaNV(ShareHelper.USER.getMaNV());
        return cd;
    }

    public boolean check() {
        if (txtHinhAnh1.getToolTipText() == null) {
            DialogHelper.alert(this, "Bạn chưa chọn hình ảnh");
            return false;
        }
//        if (Dao.findById(txtTaikhoan.getText()) != null) {
//            DialogHelper.alert(this, "Mã Nhân Viên đã tồn tại!");
//            return false;
//        }
        if (txtMatkhau.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống");
            return false;
        }
        if (txtHoten.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Họ và tên không được để trống");
            return false;
        }
        if (txtNgaysinh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống");
            return false;
        }
        Date today = new Date();
        Date date;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(txtNgaysinh.getText());
            int age = (int) ((today.getTime() - date.getTime()) / (1000 * 60 * 60 * 24 * 365.25));
            if (age < 16) {
                DialogHelper.alert(this, "Tuoi khong duoc nho hon 16");
                return false;
            }

        } catch (ParseException ex) {
            Logger.getLogger(ThongTinNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!txtHoten.getText().matches("^[\\p{L}\\s]{0,50}$")) {
            JOptionPane.showMessageDialog(this, "Họ và tên chỉ được chứa alphabet, khoảng trắng và không vượt quá 50 ký tự");
            return false;
        }
        if (txtSdt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
            return false;
        }
        if (!txtSdt.getText().matches(so)) {
            DialogHelper.alert(this, "Số điện thoại của bạn không đúng định dạng");
            return false;
        }
        if (txtDiachi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống");
            return false;
        }
        if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Email không được để trống!");
            return false;
        }
        if (!txtEmail.getText().matches("\\w+@\\w+(\\.\\w+){1,2}")) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng!");
            return false;
        }
        if (cboGioitinh.getSelectedItem() == null) {
            DialogHelper.alert(this, "Giới tính của bạn không được để trống");
            return false;
        }
        if (cboVaitro.getSelectedItem() == null) {
            DialogHelper.alert(this, "Vai trò của bạn đang để trống");
            return false;
        }

        return true;
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
        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanvien = new com.raven.swing.table.Table();
        txtNgaysinh = new com.DuAn1.Swing.TextField();
        txtEmail = new com.DuAn1.Swing.TextField();
        txtDiachi = new com.DuAn1.Swing.TextField();
        txtTaikhoan = new com.DuAn1.Swing.TextField();
        cboVaitro = new com.DuAn1.Swing.Combobox();
        cboGioitinh = new com.DuAn1.Swing.Combobox();
        txtHoten = new com.DuAn1.Swing.TextField();
        txtSdt = new com.DuAn1.Swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        btnTrangthai = new com.DuAn1.swing0.SwitchButton();
        txtTrangthai = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnMoi = new com.DuAn1.Swing.Button();
        btnThem = new com.DuAn1.Swing.Button();
        btnSua = new com.DuAn1.Swing.Button();
        btnXoa = new com.DuAn1.Swing.Button();
        txtTim = new com.DuAn1.Swing.TextField1();
        txtHinh1 = new swing.PanelShadow();
        txtHinhAnh1 = new javax.swing.JLabel();
        txtMatkhau = new com.DuAn1.Swing.PasswordField();
        jPanel2 = new javax.swing.JPanel();
        btnTang = new com.DuAn1.Swing.Button();
        btnGiam = new com.DuAn1.Swing.Button();
        cboSapXep = new com.DuAn1.Swing.Combobox();
        button15 = new com.DuAn1.Swing.Button();

        dateChooser.setTextRefernce(txtNgaysinh);

        setBackground(new java.awt.Color(255, 255, 255));

        tblNhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"dsfsdf", "dsfsd", "sdfds", "sdfs"},
                {"sdf", "sdfs", "sdf", "sdf"},
                {"dsf", "sdf", "sdf", null},
                {null, null, null, null}
            },
            new String [] {
                "sdfsdf", "sdfds", "Title 3sdfsdf", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanvienMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblNhanvienMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanvien);

        txtNgaysinh.setLabelText("Ngày sinh");
        txtNgaysinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaysinhMouseClicked(evt);
            }
        });
        txtNgaysinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaysinhActionPerformed(evt);
            }
        });

        txtEmail.setLabelText("Email");
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtDiachi.setLabelText("Địa chỉ");
        txtDiachi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDiachiMouseClicked(evt);
            }
        });

        txtTaikhoan.setLabelText("Tài khoản");
        txtTaikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTaikhoanMouseClicked(evt);
            }
        });
        txtTaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaikhoanActionPerformed(evt);
            }
        });

        cboVaitro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quản lý", "Nhân Viên" }));
        cboVaitro.setSelectedIndex(-1);
        cboVaitro.setLabeText("Vai trò");

        cboGioitinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
        cboGioitinh.setSelectedIndex(-1);
        cboGioitinh.setLabeText("Giới tính");
        cboGioitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioitinhActionPerformed(evt);
            }
        });

        txtHoten.setLabelText("Họ tên");
        txtHoten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHotenMouseClicked(evt);
            }
        });

        txtSdt.setCaretColor(new java.awt.Color(0, 0, 0));
        txtSdt.setLabelText("Số điện thoại");
        txtSdt.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtSdt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSdtMouseClicked(evt);
            }
        });

        jLabel1.setText("Trạng thái:");

        btnTrangthai.setSelectedAnimate(false);
        btnTrangthai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrangthaiMouseClicked(evt);
            }
        });

        txtTrangthai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTrangthai.setForeground(new java.awt.Color(0, 204, 51));
        txtTrangthai.setText("Ngưng hoạt động");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nhân Viên");

        btnMoi.setBackground(new java.awt.Color(153, 153, 255));
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(153, 153, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(153, 153, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 51, 51));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtTim.setHint("Tìm kiếm Mã");
        txtTim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimCaretUpdate(evt);
            }
        });
        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });
        txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKeyPressed(evt);
            }
        });

        txtHinh1.setBackground(new java.awt.Color(255, 255, 255));
        txtHinh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHinh1MouseClicked(evt);
            }
        });
        txtHinh1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHinhAnh1.setMaximumSize(new java.awt.Dimension(200, 200));
        txtHinhAnh1.setMinimumSize(new java.awt.Dimension(200, 200));
        txtHinhAnh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHinhAnh1MouseClicked(evt);
            }
        });
        txtHinh1.add(txtHinhAnh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 180));

        txtMatkhau.setCaretColor(new java.awt.Color(0, 0, 0));
        txtMatkhau.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        txtMatkhau.setLabelText("Mật khẩu");
        txtMatkhau.setLineColor(new java.awt.Color(0, 102, 204));
        txtMatkhau.setSelectedTextColor(new java.awt.Color(169, 224, 49));
        txtMatkhau.setSelectionColor(new java.awt.Color(169, 224, 49));
        txtMatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatkhauActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tiến hành sắp xếp theo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        btnTang.setBackground(new java.awt.Color(153, 153, 255));
        btnTang.setText("Tăng");
        btnTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTangActionPerformed(evt);
            }
        });

        btnGiam.setBackground(new java.awt.Color(153, 153, 255));
        btnGiam.setText("Giảm");
        btnGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cboSapXep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mã", "Họ Tên" }));
        cboSapXep.setSelectedIndex(-1);
        cboSapXep.setLabeText("Sắp xếp theo");
        cboSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSapXepActionPerformed(evt);
            }
        });

        button15.setBackground(new java.awt.Color(153, 153, 255));
        button15.setText("In thành file excel");
        button15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtHinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboVaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiachi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoten, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboSapXep, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(26, 26, 26)
                                            .addComponent(jLabel1))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtTrangthai))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboVaitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtHinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgaysinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaysinhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaysinhMouseClicked

    private void txtNgaysinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaysinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaysinhActionPerformed

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailMouseClicked

    private void txtDiachiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDiachiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiachiMouseClicked

    private void txtTaikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTaikhoanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaikhoanMouseClicked

    private void cboGioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioitinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGioitinhActionPerformed

    private void txtHotenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHotenMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHotenMouseClicked

    private void txtSdtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSdtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSdtMouseClicked

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        ClearForm();
        TuDongTangMa();
        txtMatkhau.setEditable(true);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (check() == false) {
            return;
        }
        insert();
        ClearForm();
        TuDongTangMa();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (check() == false) {
            return;
        }
        update();
        ClearForm();
        TuDongTangMa();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
        ClearForm();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblNhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvienMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNhanvienMouseClicked

    private void tblNhanvienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanvienMousePressed
        btnThem.setEnabled(false);
        if (evt.getClickCount() == 1) {
            this.row = tblNhanvien.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblNhanvienMousePressed
    String strHinh = null;
    private void txtHinh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinh1MouseClicked
//        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            File file = jFileChooser1.getSelectedFile();
//            if (ShareHelper.saveLogo(file)) {
//                // Hiển thị hình lên form
//                Image img = null;
//                try {
//                    img = ImageIO.read(file);
//                } catch (IOException ex) {
//                    Logger.getLogger(ChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                strHinh = file.getName();
//                txtHinhAnh.setText("");
//
//                txtHinhAnh.setIcon(ShareHelper.readLogo(file.getName()));
//                txtHinhAnh.setToolTipText(file.getName());
//                txtHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(165, 135, 0)));
//            }
//        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtHinh1MouseClicked

    private void txtHinhAnh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHinhAnh1MouseClicked
        if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            if (ShareHelper.saveLogo(file)) {
                // Hiển thị hình lên form
                Image img = null;
                try {
                    img = ImageIO.read(file);
                } catch (IOException ex) {
                    Logger.getLogger(ChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
                }

                strHinh = file.getName();
                txtHinhAnh1.setText("");

                txtHinhAnh1.setIcon(ShareHelper.readLogo(file.getName()));
                txtHinhAnh1.setToolTipText(file.getName());
                txtHinhAnh1.setIcon(new ImageIcon(img.getScaledInstance(165, 135, 0)));
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtHinhAnh1MouseClicked

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed

    }//GEN-LAST:event_txtTimActionPerformed

    private void txtTimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyPressed

    }//GEN-LAST:event_txtTimKeyPressed

    private void txtMatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatkhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatkhauActionPerformed

    private void txtTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimCaretUpdate
        if (txtTim.getText().equals("")) {
            this.filltable();
        } else {
            model = (DefaultTableModel) tblNhanvien.getModel();
            model.setRowCount(0);
            try {
                List<NhanVienModel> list = Dao.TimKiemTheoTen(txtTim.getText());
                for (NhanVienModel nv : list) {
                    Object[] row = new Object[]{nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ",
                        nv.getDiaChi(), nv.getSDT(), nv.getVaiTro(), nv.getHinh(), nv.isTrangThai() ? "Đang hoạt động" : "Không hoạt động"};
                    model.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }
    }//GEN-LAST:event_txtTimCaretUpdate

    private void txtTaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaikhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTaikhoanActionPerformed

    private void btnTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTangActionPerformed
        if (cboSapXep.getSelectedItem() == null) {
            DialogHelper.alert(this, "Bạn cần chọn hình thức sắp xếp");
            return;
        }
        if (cboSapXep.getSelectedItem().equals("Mã")) {
            model = (DefaultTableModel) tblNhanvien.getModel();
            model.setRowCount(0);
            try {
                List<NhanVienModel> list = Dao.orderByMaTang();
                for (NhanVienModel nv : list) {
                    Object[] row = new Object[]{nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ",
                        nv.getDiaChi(), nv.getSDT(), nv.getVaiTro(), nv.getHinh(), nv.isTrangThai() ? "Đang hoạt động" : "Không hoạt động"};
                    model.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }

        } else {

            model = (DefaultTableModel) tblNhanvien.getModel();
            model.setRowCount(0);
            try {
                List<NhanVienModel> list = Dao.orderByTen();
                for (NhanVienModel nv : list) {
                    Object[] row = new Object[]{nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ",
                        nv.getDiaChi(), nv.getSDT(), nv.getVaiTro(), nv.getHinh(), nv.isTrangThai() ? "Đang hoạt động" : "Không hoạt động"};
                    model.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }
    }//GEN-LAST:event_btnTangActionPerformed

    private void btnGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiamActionPerformed
        if (cboSapXep.getSelectedItem() == null) {
            DialogHelper.alert(this, "Bạn cần chọn hình thức sắp xếp");
            return;
        }
        if (cboSapXep.getSelectedItem().equals("Mã")) {
            model = (DefaultTableModel) tblNhanvien.getModel();
            model.setRowCount(0);
            try {
                List<NhanVienModel> list = Dao.orderByMaGiam();
                for (NhanVienModel nv : list) {
                    Object[] row = new Object[]{nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ",
                        nv.getDiaChi(), nv.getSDT(), nv.getVaiTro(), nv.getHinh(), nv.isTrangThai() ? "Đang hoạt động" : "Không hoạt động"};
                    model.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }

        } else {

            model = (DefaultTableModel) tblNhanvien.getModel();
            model.setRowCount(0);
            try {
                List<NhanVienModel> list = Dao.orderByTenGiam();
                for (NhanVienModel nv : list) {
                    Object[] row = new Object[]{nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ",
                        nv.getDiaChi(), nv.getSDT(), nv.getVaiTro(), nv.getHinh(), nv.isTrangThai() ? "Đang hoạt động" : "Không hoạt động"};
                    model.addRow(row);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
            }
        }
    }//GEN-LAST:event_btnGiamActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void cboSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSapXepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSapXepActionPerformed

    private void button15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button15ActionPerformed
        btnInDanhSach();        // TODO add your handling code here:
    }//GEN-LAST:event_button15ActionPerformed

    private void btnTrangthaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangthaiMouseClicked
        if (btnTrangthai.isSelected() == false) {
            txtTrangthai.setText("Đang hoạt động");
        } else {
            txtTrangthai.setText("Chưa hoạt động");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrangthaiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.DuAn1.Swing.Button btnGiam;
    private com.DuAn1.Swing.Button btnMoi;
    private com.DuAn1.Swing.Button btnSua;
    private com.DuAn1.Swing.Button btnTang;
    private com.DuAn1.Swing.Button btnThem;
    private com.DuAn1.swing0.SwitchButton btnTrangthai;
    private com.DuAn1.Swing.Button btnXoa;
    private com.DuAn1.Swing.Button button15;
    private com.DuAn1.Swing.Combobox cboGioitinh;
    private com.DuAn1.Swing.Combobox cboSapXep;
    private com.DuAn1.Swing.Combobox cboVaitro;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.table.Table tblNhanvien;
    private com.DuAn1.Swing.TextField txtDiachi;
    private com.DuAn1.Swing.TextField txtEmail;
    private swing.PanelShadow txtHinh1;
    private javax.swing.JLabel txtHinhAnh1;
    private com.DuAn1.Swing.TextField txtHoten;
    private com.DuAn1.Swing.PasswordField txtMatkhau;
    private com.DuAn1.Swing.TextField txtNgaysinh;
    private com.DuAn1.Swing.TextField txtSdt;
    private com.DuAn1.Swing.TextField txtTaikhoan;
    private com.DuAn1.Swing.TextField1 txtTim;
    private javax.swing.JLabel txtTrangthai;
    // End of variables declaration//GEN-END:variables
}
