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
public class XeDuLich {
     private String maxe;
    private String bienso;
    private String soghe;
    String manv;
    
    public XeDuLich(){
        
    }
    
    public XeDuLich(String maxe, String bienso, String soghe, String manv){
        this.maxe = maxe;
        this.bienso = bienso;
        this.soghe = soghe;
        this.manv = manv;
    }

    public String getMaxe() {
        return maxe;
    }

    public String getBienso() {
        return bienso;
    }

    public String getSoghe() {
        return soghe;
    }

    public String getManv() {
        return manv;
    }

    public void setMaxe(String maxe) {
        this.maxe = maxe;
    }

    public void setBienso(String bienso) {
        this.bienso = bienso;
    }

    public void setSoghe(String soghe) {
        this.soghe = soghe;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    @Override
    public String toString() {
        return "XeDuLich{" + "maxe=" + maxe + ", bienso=" + bienso + ", soghe=" + soghe + ", manv=" + manv + '}';
    }
    
}
