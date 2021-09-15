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
public class DiaDanh {
    private String madiadanh;
    private String tendiadanh;
    
    public DiaDanh(){
        
    }
    public DiaDanh(String madiadanh, String tendiadanh){
        this.madiadanh = madiadanh;
        this.tendiadanh = tendiadanh;
    }

    public String getMadiadanh() {
        return madiadanh;
    }

    public void setMadiadanh(String madiadanh) {
        this.madiadanh = madiadanh;
    }

    public String getTendiadanh() {
        return tendiadanh;
    }

    public void setTendiadanh(String tendiadanh) {
        this.tendiadanh = tendiadanh;
    }

    @Override
    public String toString() {
        return "DiaDanh{" + "madiadanh=" + madiadanh + ", tendiadanh=" + tendiadanh + '}';
    }
    
    
}
