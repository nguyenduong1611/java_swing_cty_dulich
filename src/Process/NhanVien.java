/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class NhanVien {
    private String manv;
    private String matkhau;
    private String tennv;
    private String gioitinh;
    private String ngaysinh;
    private String diachi;
    String machucvu;
    String macalam;
    private String luong;
    
    public NhanVien(){
        
    }
    public NhanVien(String manv, String matkhau, String tennv, String gioitinh, String ngaysinh, String diachi, String machucvu, String macalam, String luong){
        this.manv = manv;
        this.matkhau = matkhau;
        this.tennv = tennv;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.machucvu = machucvu;
        this.macalam = macalam;
        this.luong = luong;
    }
    
    public NhanVien(String TK, String MK, String CV){
        this.manv = TK;
        this.matkhau = MK;
        this.machucvu = CV;
    }

    public String getManv() {
        return manv;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public String getTennv() {
        return tennv;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getMachucvu() {
        return machucvu;
    }

    public String getMacalam() {
        return macalam;
    }

    public String getLuong() {
        return luong;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }

    public void setMacalam(String macalam) {
        this.macalam = macalam;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    

    @Override
    public String toString() {
        return manv ;
    }
    
    
    
    
}
