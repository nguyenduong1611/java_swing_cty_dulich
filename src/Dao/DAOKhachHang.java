/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Process.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DAOKhachHang {
    public static List<KhachHang> getallTT(String query) throws SQLException, ClassNotFoundException{


        List<KhachHang> lstkhachhang = new ArrayList<>();
        ResultSet rs = Tien_ich.KetNoi.ketnoi("Project_CuoiMon_java").createStatement().executeQuery(query);
        // xu ly ket qua tra ve;
        while(rs.next()){
            KhachHang kh=new KhachHang();

                kh.setMakh(rs.getString(1));
                kh.setTenkh(rs.getString(2));
                kh.setGioitinh(rs.getString(3));
                kh.setNgaysinh(rs.getString(4));
                kh.setSdt(rs.getString(5));
                kh.setEmail(rs.getString(6));
                kh.setDiachi(rs.getString(7));

            lstkhachhang.add(kh);
        }
        return lstkhachhang;
    }
    public static List<KhachHang> ListHD() throws SQLException, ClassNotFoundException {
        String sql = "select * from KhachHang";
        return getallTT(sql);
    }
}
