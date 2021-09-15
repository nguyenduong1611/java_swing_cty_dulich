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
public class ChucVu {
    private String machucvu;
    private String tenchucvu;
    private float hesopc;
    
    public ChucVu(){
        
    }
    public ChucVu(String machucvu, String tenchucvu, float hesopc){
        this.machucvu = machucvu;
        this.tenchucvu = tenchucvu;
        this.hesopc = hesopc;
    }

    public String getMachucvu() {
        return machucvu;
    }

    public void setMachucvu(String machucvu) {
        this.machucvu = machucvu;
    }

    public String getTenchucvu() {
        return tenchucvu;
    }

    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }

    public float getHesopc() {
        return hesopc;
    }

    public void setHesopc(float hesopc) {
        this.hesopc = hesopc;
    }

    @Override
    public String toString() {
        return machucvu ;
    }
    
    
}
