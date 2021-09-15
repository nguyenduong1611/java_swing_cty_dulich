/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import Process.KhachHang;
import Process.NhanVien;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ASUS
 */
public class ViewNhanVien {
    public static void LoadTable(JTable tbl, List list) {
        List<NhanVien> lstnhanvien = list;
        Object[] colName = new Object[]{"Mã nhân viên", "Mật khẩu", "Tên nhân viên", "Giới tính", "Ngày sinh", "Địa chỉ", "Mã chức vụ", "Mã ca làm", "Lương"};
        Object[][] data = new Object[lstnhanvien.size()][7];
        int i = 0;
        for (NhanVien kh : lstnhanvien) {
            data[i][0] = kh.getManv();
            data[i][1] = kh.getMatkhau();
            data[i][2] = kh.getTennv();
            data[i][3] = kh.getGioitinh();
            data[i][4] = kh.getNgaysinh();
            data[i][5] = kh.getDiachi();
            data[i][6] = kh.getMachucvu();
            data[i][7] = kh.getMacalam();
            data[i][8] = kh.getLuong();
            i++;
        }
        TableModel tableModel = new DefaultTableModel(data, colName);
        tbl.setModel(tableModel);
    }

    public static void HienThiThongTinKH(JTable tbl) throws SQLException, ClassNotFoundException {
        List<NhanVien> lstnhanvien = Dao.DAONhanVien.ListHD();
        LoadTable(tbl, lstnhanvien);
    }
}
