/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Process.HoaDon;
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
public class DAOHoaDOn {
     public static List<HoaDon> getAllKH() throws ClassNotFoundException, SQLException{
        List<HoaDon> lstHoaDon = new ArrayList<>();
        Connection cnn = Tien_ich.KetNoi.ketnoi("Project_CuoiMon_java");
        String query = "select * from HoaDon";
        PreparedStatement stm = cnn.prepareStatement(query);
        ResultSet rs = stm.executeQuery();
        while(rs.next()){
            HoaDon hd = new HoaDon();
            hd.setMahd(rs.getString("mahd"));
            hd.setMakh(rs.getString("makh"));
            hd.setMatour(rs.getString("matour"));
            hd.setSonguoi(rs.getString("songuoi"));
            hd.setDiembatdau(rs.getString("diembatdau"));
            hd.setThoigian(rs.getString("thoigian"));
            hd.setNgaykhoihanh(rs.getString("ngaykhoihanh"));
            hd.setMaxe(rs.getString("maxe"));
            hd.setThanhtien(rs.getString("thanhtien"));
            hd.setManv(rs.getString("manv"));
            lstHoaDon.add(hd);
        }
        return lstHoaDon;
    }
}
