/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Process.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DAONhanVien {
     public static List<NhanVien> getallTT(String query) throws SQLException, ClassNotFoundException{


        List<NhanVien> lstnhanvien = new ArrayList<>();
        ResultSet rs = Tien_ich.KetNoi.ketnoi("Project_CuoiMon_java").createStatement().executeQuery(query);
        // xu ly ket qua tra ve;
        while(rs.next()){
            NhanVien kh=new NhanVien();

                kh.setManv(rs.getString(1));
                kh.setMatkhau(rs.getString(2));
                kh.setTennv(rs.getString(3));
                kh.setGioitinh(rs.getString(4));
                kh.setNgaysinh(rs.getString(5));
                kh.setDiachi(rs.getString(6));
                kh.setMachucvu(rs.getString(7));
                kh.setMacalam(rs.getString(8));
                kh.setLuong(rs.getString(9));

            lstnhanvien.add(kh);
        }
        return lstnhanvien;
    }
    public static List<NhanVien> ListHD() throws SQLException, ClassNotFoundException {
        String sql = "select * from NhanVien";
        return getallTT(sql);
    }
}
