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
public class TourDuLich {
    private String matour;
    private String tentour;
    String madiadanh;
    private String songay;
    private float gia;
    private String tinhtrang;
    
    public TourDuLich(){
        
    }
    public TourDuLich(String matour,String tentour, String madiadanh, String songay, float gia, String tinhtrang){
        this.matour = matour;
        this.tentour = tentour;
        this.madiadanh = madiadanh;
        this.songay = songay;
        this.gia = gia;
        this.tinhtrang = tinhtrang;
    }

    public String getMatour() {
        return matour;
    }

    public String getTentour() {
        return tentour;
    }

    public String getMadiadanh() {
        return madiadanh;
    }

    public String getSongay() {
        return songay;
    }

    public float getGia() {
        return gia;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    @Override
    public String toString() {
        return matour ;
    }

    
}
