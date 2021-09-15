/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.Time;
import java.util.Date;



/**
 *
 * @author ASUS
 */
public class HoaDon {
    private String mahd;
    String makh;
    String matour;
    private String songuoi;
    private String diembatdau;
    private String thoigian;
    private String ngaykhoihanh;
    String maxe;
    private String thanhtien;
    String manv;
    
    public HoaDon(){
        
    }
    public HoaDon(String mahd, String makh, String matour, String songuoi, String diembatdau, String thoigian, String ngaykhoihanh, String maxe, String thanhtien, String manv){
        this.mahd = mahd;
        this.makh = makh;
        this.matour = matour;
        this.songuoi = songuoi;
        this.diembatdau = diembatdau;
        this.thoigian = thoigian;
        this.ngaykhoihanh = ngaykhoihanh;
        this.maxe = maxe;
        this.thanhtien = thanhtien;
        this.manv = manv;
    }
    public String getMahd() {
        return mahd;
    }

    public String getMakh() {
        return makh;
    }

    public String getMatour() {
        return matour;
    }

    public String getSonguoi() {
        return songuoi;
    }

    public String getDiembatdau() {
        return diembatdau;
    }

    public String getThoigian() {
        return thoigian;
    }

    public String getNgaykhoihanh() {
        return ngaykhoihanh;
    }

    public String getMaxe() {
        return maxe;
    }

    public String getThanhtien() {
        return thanhtien;
    }

    public String getManv() {
        return manv;
    }
    
    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public void setMatour(String matour) {
        this.matour = matour;
    }

    public void setSonguoi(String songuoi) {
        this.songuoi = songuoi;
    }

    public void setDiembatdau(String diembatdau) {
        this.diembatdau = diembatdau;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public void setNgaykhoihanh(String ngaykhoihanh) {
        this.ngaykhoihanh = ngaykhoihanh;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public void setThanhtien(String thanhtien) {
        this.thanhtien = thanhtien;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "mahd=" + mahd + ", makh=" + makh + ", matour=" + matour + ", songuoi=" + songuoi + ", diembatdau=" + diembatdau + ", thoigian=" + thoigian + ", ngaykhoihanh=" + ngaykhoihanh + ", maxe=" + maxe + ", thanhtien=" + thanhtien + ", manv=" + manv + '}';
    }
    
    
    
    
}
