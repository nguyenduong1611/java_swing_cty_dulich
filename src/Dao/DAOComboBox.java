/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Process.ChucVu;
import Process.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DAOComboBox {
    public static List<KhachHang> getAllKH() throws ClassNotFoundException, SQLException{
        List<KhachHang> lstKhachHang = new ArrayList<>();
        Connection cnn = Tien_ich.KetNoi.ketnoi("Project_CuoiMon_java");
        String query = "select * from KhachHang";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            KhachHang kh = new KhachHang();
            kh.setMakh(rs.getString("makh"));
            kh.setTenkh(rs.getString("tenkh"));
            kh.setGioitinh(rs.getString("gioitinh"));
            kh.setNgaysinh(rs.getString("ngaysinh"));
            kh.setSdt(rs.getString("sdt"));
            kh.setEmail(rs.getString("email"));
            kh.setDiachi(rs.getString("diachi"));
            lstKhachHang.add(kh);
        }
        return lstKhachHang;
    }
    
    public static ChucVu SelectByID(String mcv) throws ClassNotFoundException, SQLException{
        ChucVu CV = new ChucVu();
        Connection cnn = Tien_ich.KetNoi.ketnoi("Project_CuoiMon_java");
        String query = "select * from ChucVu where machucvu = ?";
        PreparedStatement stm = cnn.prepareStatement(query);
        stm.setString(1, mcv);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            CV.setMachucvu(rs.getString("machucvu"));
            CV.setTenchucvu(rs.getString("tenchucvu"));
            CV.setHesopc(rs.getFloat("hesopc"));
//            new ChucVu(, mcv, 0)
        }
        System.out.println(CV);
        return CV;
    }
}
