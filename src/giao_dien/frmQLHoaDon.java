/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giao_dien;

import Process.HoaDon;
import Process.KhachHang;
import Process.NhanVien;
import Process.TourDuLich;
import Process.XeDuLich;
import Tien_ich.KetNoi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Time;
import java.text.ParseException;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ASUS
 */
public class frmQLHoaDon extends javax.swing.JInternalFrame {

    Connection conn;
    int index;
    ArrayList<HoaDon> list = new ArrayList<>();
//    frmQLKhachHang frmKH = new frmQLKhachHang();

    /**
     * Creates new form frmQLHoaDon
     */
    public frmQLHoaDon() {
        initComponents();
        panThemKhachHang.setVisible(false);
        conn = KetNoi.ketnoi("Project_CuoiMon_java");
        if (conn != null) {
//            System.out.println("Kết nối thành công.");
            loadDataToList();
            fillComboBoxMaKH();
            fillComboBoxMaTour();
            fillComboBoxMaXe();
            fillComboBoxMaNV();
            fillToTable();;
        } else {
            System.out.println("Lỗi kết nối!!!");
        }
    }

    //Lấy danh sách
    private void loadDataToList() {
        try {
            String sql = "select * from HoaDon";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //duyệt rs => đổ dữ liệu vào list
            while (rs.next()) {
                String mahd = rs.getString("mahd");
                String makh = rs.getString("makh");
                String matour = rs.getString("matour");
                String songuoi = rs.getString("songuoi");
                String diembatdau = rs.getString("diembatdau");
                String thoigian = rs.getString("thoigian");
                String ngaykhoihanh = rs.getString("ngaykhoihanh");
                String maxe = rs.getString("maxe");
                String thanhtien = rs.getString("thanhtien");
                String manv = rs.getString("manv");
                list.add(new HoaDon(mahd, makh, matour, songuoi, diembatdau, thoigian, ngaykhoihanh, maxe, thanhtien, manv));
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi load data to list");
        }
    }

    //Hiển thị danh sách trên table
    public void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        for (HoaDon kh : list) {
            model.addRow(new Object[]{
                kh.getMahd(),
                kh.getMakh(),
                kh.getMatour(),
                kh.getSonguoi(),
                kh.getDiembatdau(),
                kh.getThoigian(),
                kh.getNgaykhoihanh(),
                kh.getMaxe(),
                kh.getThanhtien(),
                kh.getManv(),});
        }
    }

    public void showDetail(int index) {
        HoaDon hd = list.get(index);
        
        txtMaHD.setText(hd.getMahd());
        cbbMaKH.setSelectedItem(hd.getMakh());
        cbbMaTour.setSelectedItem(hd.getMatour());
        txtSoNguoi.setText(hd.getSonguoi());
        txtDiemBatDau.setText(hd.getDiembatdau());
        txtThoiGian.setText(hd.getThoigian());
        txtNgayKhoiHanh.setText(hd.getNgaykhoihanh());
        cbbMaXe.setSelectedItem(hd.getMaxe());
        txtThanhTien.setText(hd.getThanhtien());
        cbbMaNV.setSelectedItem(hd.getManv());
        tblHoaDon.setRowSelectionInterval(index, index);
        
    }

    void fillComboBoxMaKH() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbMaKH.getModel();
        model.removeAllElements();
        ArrayList<KhachHang> listCboKH = new ArrayList<>();
        try {
            String sql = "select * from KhachHang";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String makh = rs.getString("makh");
                String tenkh = rs.getString("tenkh");
                String gioitinh = rs.getString("gioitinh");
                String ngaysinh = rs.getString("ngaysinh");
                String sdt = rs.getString("sdt");
                String email = rs.getString("email");
                String diachi = rs.getString("diachi");
                listCboKH.add(new KhachHang(makh, tenkh, gioitinh, ngaysinh, sdt, email, diachi));
            }
            st.close();
            rs.close();
            for (KhachHang kh : listCboKH) {
                model.addElement(kh.getMakh());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void fillComboBoxMaTour() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbMaTour.getModel();
        model.removeAllElements();
        ArrayList<TourDuLich> listCboMaTour = new ArrayList<>();
        try {
            String sql = "select * from TourDuLich";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String matour = rs.getString("matour");
                String tentour = rs.getString("tentour");
                String madiadanh = rs.getString("madiadanh");
                String songay = rs.getString("songay");
                float gia = rs.getFloat("gia");
                String tinhtrang = rs.getString("tinhtrang");
                listCboMaTour.add(new TourDuLich(matour, tentour, madiadanh, songay, gia, tinhtrang));
            }
            st.close();
            rs.close();
            for (TourDuLich tdl : listCboMaTour) {
                model.addElement(tdl.getMatour());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void fillComboBoxMaXe() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbMaXe.getModel();
        model.removeAllElements();
        ArrayList<XeDuLich> listCboMaXe = new ArrayList<>();
        try {
            String sql = "select * from XeDuLich";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String maxe = rs.getString("maxe");
                String bienso = rs.getString("bienso");
                String soghe = rs.getString("soghe");
                String manv = rs.getString("manv");

                listCboMaXe.add(new XeDuLich(maxe, bienso, soghe, manv));
            }
            st.close();
            rs.close();
            for (XeDuLich xdl : listCboMaXe) {
                model.addElement(xdl.getMaxe());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void fillComboBoxMaNV() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbMaNV.getModel();
        model.removeAllElements();
        ArrayList<NhanVien> listCboNV = new ArrayList<>();
        try {
            String sql = "select * from NhanVien";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String manv = rs.getString("manv");
                String matkhau = rs.getString("matkhau");
                String tennv = rs.getString("tennv");
                String gioitinh = rs.getString("gioitinh");
                String ngaysinh = rs.getString("ngaysinh");
                String diachi = rs.getString("diachi");
                String machucvu = rs.getString("machucvu");
                String macalam = rs.getString("macalam");
                String luong = rs.getString("luong");
                listCboNV.add(new NhanVien(manv, matkhau, tennv, gioitinh, ngaysinh, diachi, machucvu, macalam, luong));
            }
            st.close();
            rs.close();
            for (NhanVien nv : listCboNV) {
                model.addElement(nv.getManv());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void ThemKhachHangMoi() {
        ArrayList<KhachHang> listKH = new ArrayList<>();
        try {
            String makh = txtMaKH.getText();
            String tenkh = txtTenKH.getText();
            String gioitinh;
            if (rdoNam.isSelected()) {
                gioitinh = "nam";
            } else {
                gioitinh = "nữ";
            }
            String ngaysinh = txtNgaySinh.getText();
            String sdt = txtSDT.getText();
            String email = txtEmail.getText();
            String diachi = txtDiaChi.getText();
            listKH.add(new KhachHang(makh, tenkh, gioitinh, ngaysinh, sdt, email, diachi));
//            frmKH.list.add(new KhachHang(makh, tenkh, gioitinh, ngaysinh, sdt, email, diachi));
            //them vao database
            String sql = "insert into KhachHang(makh,tenkh,gioitinh,ngaysinh,sdt,email,diachi) values('" + makh + "',N'" + tenkh + "',N'" + gioitinh + "','" + ngaysinh + "','" + sdt + "','" + email + "',N'" + diachi + "')";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Thêm khách hàng mới thành công ");
//            frmKH.fillToTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Thêm khách hàng mới không thành công ");
        }
    }

    private void insert() {
        try {
            String mahd = txtMaHD.getText();
            String makh = cbbMaKH.getSelectedItem().toString();
            String matour = cbbMaTour.getSelectedItem().toString();
            String songuoi = txtSoNguoi.getText();
            String diembatdau = txtDiemBatDau.getText();
            String thoigian = txtThoiGian.getText();
            String ngaykhoihanh = txtNgayKhoiHanh.getText();
            String maxe = cbbMaXe.getSelectedItem().toString();
            String thanhtien = txtThanhTien.getText();
            String manv = cbbMaNV.getSelectedItem().toString();
            list.add(new HoaDon(mahd, makh, matour, songuoi, diembatdau, thoigian, ngaykhoihanh, maxe, thanhtien, manv));
            //them vao database
            String sql = "insert into HoaDon (mahd, makh, matour, songuoi, diembatdau, thoigian, ngaykhoihanh, maxe, thanhtien, manv) values ('" + mahd + "','" + makh + "', '" + matour + "', N'" + songuoi + "', N'" + diembatdau + "', N'" + thoigian + "','" + ngaykhoihanh + "','" + maxe + "','" + thanhtien + "', '" + manv + "')";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công ");
            fillToTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Thêm hóa đơn không thành công ");
        }
    }

    public void delete() {
        try {
            if (list.size() <= 0) {
                JOptionPane.showMessageDialog(this, "Không còn dữ liệu để xóa ");
                return;
            }
            int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "HỎi xóa", JOptionPane.YES_NO_OPTION);
            if (hoi != JOptionPane.YES_OPTION) {
                return;
            }
            //xóa trong list
            index = tblHoaDon.getSelectedRow();
            list.remove(index);
//            
            //xóa trong CSDL
            String sql = "delete from HoaDon\n"
                    + "where mahd = '" + txtMaHD.getText() + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Xóa dữ liệu thành công ");
            fillToTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi xóa hóa đơn");
        }
    }

    private void update() {
        try {
            String mahd = txtMaHD.getText();
            String makh = cbbMaKH.getSelectedItem().toString();
            String matour = cbbMaTour.getSelectedItem().toString();
            String songuoi = txtSoNguoi.getText();
            String diembatdau = txtDiemBatDau.getText();
            String thoigian = txtThoiGian.getText();
            String ngaykhoihanh = txtNgayKhoiHanh.getText();
            String maxe = cbbMaXe.getSelectedItem().toString();
            String thanhtien = txtThanhTien.getText();
            String manv = cbbMaNV.getSelectedItem().toString();
            list.set(index, new HoaDon(mahd, makh, matour, songuoi, diembatdau, thoigian, ngaykhoihanh, maxe, thanhtien, manv));
            //them vao database
            String sql = "update HoaDon set makh= '" + makh + "', matour= '" + matour + "', songuoi= '" + songuoi + "', diembatdau= N'" + diembatdau + "', thoigian= '" + thoigian + "', ngaykhoihanh= '" + ngaykhoihanh + "', maxe= '" + maxe + "', thanhtien= '" + thanhtien + "', manv= '" + manv + "' where mahd= '" + mahd + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Sửa hóa đơn thành công ");
            fillToTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Sửa hóa đơn không thành công ");
        }
    }
    
    public void ClearForm() {
        try {
            this.txtMaHD.setText("");
            this.cbbMaKH.setSelectedIndex(0);
            this.cbbMaTour.setSelectedIndex(0);
            this.txtSoNguoi.setText("");
            this.txtDiemBatDau.setText("");
            this.txtThoiGian.setText("");
            this.txtNgayKhoiHanh.setText("");
            this.cbbMaXe.setSelectedIndex(0);
            this.txtThanhTien.setText("");
            this.cbbMaNV.setSelectedIndex(0);
        } catch (Exception e) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtSoNguoi = new javax.swing.JTextField();
        txtDiemBatDau = new javax.swing.JTextField();
        txtThoiGian = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        cbbMaKH = new javax.swing.JComboBox<>();
        ckbKhachHangMoi = new javax.swing.JCheckBox();
        panThemKhachHang = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        btnThemKH = new javax.swing.JButton();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        btnThemHD = new javax.swing.JButton();
        btnSuaHD = new javax.swing.JButton();
        btnXoaHD = new javax.swing.JButton();
        cbbMaTour = new javax.swing.JComboBox<>();
        cbbMaXe = new javax.swing.JComboBox<>();
        cbbMaNV = new javax.swing.JComboBox<>();
        txtNgayKhoiHanh = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1337, 695));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Mã khách hàng", "Mã tour", "Số người", "Điểm bắt đầu", "Thời gian", "Ngày khởi hành", "Mã xe", "Thành tiền", "Mã nhân viên"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã hóa đơn:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mã Khách Hàng:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Mã Tour:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Số người:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Điểm bắt đầu:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Thời Gian:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Ngày Khởi hành:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Mã xe:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Thành Tiền:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Mã Nhân Viên:");

        cbbMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaKHActionPerformed(evt);
            }
        });

        ckbKhachHangMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckbKhachHangMoi.setText("Khách hàng mới");
        ckbKhachHangMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbKhachHangMoiActionPerformed(evt);
            }
        });

        panThemKhachHang.setBackground(new java.awt.Color(204, 204, 204));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Mã khách hàng:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Giới Tính:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Số Điện Thoại:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Ngày Sinh:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Email:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Địa Chỉ:");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        btnThemKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save as.png"))); // NOI18N
        btnThemKH.setText("Thêm");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        txtNgaySinh.setToolTipText("");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Tên Khách hàng:");

        javax.swing.GroupLayout panThemKhachHangLayout = new javax.swing.GroupLayout(panThemKhachHang);
        panThemKhachHang.setLayout(panThemKhachHangLayout);
        panThemKhachHangLayout.setHorizontalGroup(
            panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panThemKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panThemKhachHangLayout.createSequentialGroup()
                        .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panThemKhachHangLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panThemKhachHangLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panThemKhachHangLayout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(rdoNam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                        .addComponent(rdoNu)
                                        .addGap(40, 40, 40))
                                    .addComponent(txtMaKH)
                                    .addComponent(txtTenKH)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panThemKhachHangLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panThemKhachHangLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panThemKhachHangLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panThemKhachHangLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panThemKhachHangLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(btnThemKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panThemKhachHangLayout.setVerticalGroup(
            panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panThemKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panThemKhachHangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panThemKhachHangLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panThemKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnLamMoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnThemHD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThemHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save.png"))); // NOI18N
        btnThemHD.setText("Thêm");
        btnThemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHDActionPerformed(evt);
            }
        });

        btnSuaHD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSuaHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Edit.png"))); // NOI18N
        btnSuaHD.setText("Sửa");
        btnSuaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHDActionPerformed(evt);
            }
        });

        btnXoaHD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoaHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        btnXoaHD.setText("Xóa");
        btnXoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDActionPerformed(evt);
            }
        });

        cbbMaTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaTourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbbMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ckbKhachHangMoi))))
                    .addComponent(panThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiemBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNgayKhoiHanh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMaXe, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThoiGian, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnXoaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSuaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnLamMoi))
                .addContainerGap(257, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(cbbMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cbbMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ckbKhachHangMoi)
                                    .addComponent(jLabel5)
                                    .addComponent(txtSoNguoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDiemBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtNgayKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cbbMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(cbbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnThemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ckbKhachHangMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbKhachHangMoiActionPerformed
        // TODO add your handling code here:
        if (ckbKhachHangMoi.isSelected()) {
            panThemKhachHang.setVisible(true);
        } else {
            panThemKhachHang.setVisible(false);
        }
    }//GEN-LAST:event_ckbKhachHangMoiActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
         // TODO add your handling code here:
        index = tblHoaDon.getSelectedRow();
        showDetail(index);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        // TODO add your handling code here:
        ThemKhachHangMoi();
        fillComboBoxMaKH();
        panThemKhachHang.setVisible(false);
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void cbbMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMaKHActionPerformed

    private void cbbMaTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaTourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMaTourActionPerformed

    private void btnThemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHDActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnThemHDActionPerformed

    private void btnXoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaHDActionPerformed

    private void btnSuaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHDActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnSuaHDActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        ClearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSuaHD;
    private javax.swing.JButton btnThemHD;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnXoaHD;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbMaKH;
    private javax.swing.JComboBox<String> cbbMaNV;
    private javax.swing.JComboBox<String> cbbMaTour;
    private javax.swing.JComboBox<String> cbbMaXe;
    private javax.swing.JCheckBox ckbKhachHangMoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panThemKhachHang;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiemBatDau;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgayKhoiHanh;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoNguoi;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtThoiGian;
    // End of variables declaration//GEN-END:variables
}
