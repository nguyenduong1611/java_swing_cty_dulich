/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Process.KhachHang;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ASUS
 */
public class ViewKhachHang {

    public static void LoadTable(JTable tbl, List list) {
        List<KhachHang> lstkhachhang = list;
        Object[] colName = new Object[]{"Mã khách hàng", "Tên khách hàng", "Giới tính", "Ngày sinh", "Số điện thoại", "Email", "Địa chỉ"};
        Object[][] data = new Object[lstkhachhang.size()][7];
        int i = 0;
        for (KhachHang kh : lstkhachhang) {
            data[i][0] = kh.getMakh();
            data[i][1] = kh.getTenkh();
            data[i][2] = kh.getGioitinh();
            data[i][3] = kh.getNgaysinh();
            data[i][4] = kh.getSdt();
            data[i][5] = kh.getEmail();
            data[i][6] = kh.getDiachi();
            i++;
        }
        TableModel tableModel = new DefaultTableModel(data, colName);
        tbl.setModel(tableModel);
    }

    public static void HienThiThongTinKH(JTable tbl) throws SQLException, ClassNotFoundException {
        List<KhachHang> lstkhachhang = Dao.DAOKhachHang.ListHD();
        LoadTable(tbl, lstkhachhang);
    }
}
