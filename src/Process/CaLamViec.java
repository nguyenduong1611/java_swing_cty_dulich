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
public class CaLamViec {
    private String macalam;
    private String tenca;
    private int sogio1ca;
    private int soca1tuan;
    
    public CaLamViec(){
        
    }
    
    public CaLamViec(String macalam, String tenca, int sogio1ca, int soca1tuan){
        this.macalam = macalam;
        this.tenca = tenca;
        this.sogio1ca = sogio1ca;
        this.soca1tuan = soca1tuan;
    }

    public String getMacalam() {
        return macalam;
    }

    public void setMacalam(String macalam) {
        this.macalam = macalam;
    }

    public String getTenca() {
        return tenca;
    }

    public void setTenca(String tenca) {
        this.tenca = tenca;
    }

    public int getSogio1ca() {
        return sogio1ca;
    }

    public void setSogio1ca(int sogio1ca) {
        this.sogio1ca = sogio1ca;
    }

    public int getSoca1tuan() {
        return soca1tuan;
    }

    public void setSoca1tuan(int soca1tuan) {
        this.soca1tuan = soca1tuan;
    }

    @Override
    public String toString() {
        return macalam;
    }
    
    
}
