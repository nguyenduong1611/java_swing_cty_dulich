/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

/**
 *
 * @author ASUS
 */
public class ThongKe {
    private String thang;
    private float doanhthu;
    private float luongnv;
    private float baoduongxe;
    private float phidichvu;
    private float loinhuan;
    
    public ThongKe(){
        
    }
    public ThongKe(String thang, float doanhthu, float luongnv, float baoduongxe, float phidichvu, float loinhuan){
        this.thang = thang;
        this.doanhthu = doanhthu;
        this.luongnv = luongnv;
        this.baoduongxe = baoduongxe;
        this.phidichvu = phidichvu;
        this.loinhuan = loinhuan;
    }

    public String getThang() {
        return thang;
    }

    public float getDoanhthu() {
        return doanhthu;
    }

    public float getLuongnv() {
        return luongnv;
    }

    public float getBaoduongxe() {
        return baoduongxe;
    }

    public float getPhidichvu() {
        return phidichvu;
    }

    public float getLoinhuan() {
        return loinhuan;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public void setDoanhthu(float doanhthu) {
        this.doanhthu = doanhthu;
    }

    public void setLuongnv(float luongnv) {
        this.luongnv = luongnv;
    }

    public void setBaoduongxe(float baoduongxe) {
        this.baoduongxe = baoduongxe;
    }

    public void setPhidichvu(float phidichvu) {
        this.phidichvu = phidichvu;
    }

    public void setLoinhuan(float loinhuan) {
        this.loinhuan = loinhuan;
    }

    @Override
    public String toString() {
        return "ThongKe{" + "thang=" + thang + ", doanhthu=" + doanhthu + ", luongnv=" + luongnv + ", baoduongxe=" + baoduongxe + ", phidichvu=" + phidichvu + ", loinhuan=" + loinhuan + '}';
    }
    
    
}
