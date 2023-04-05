/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

/**
 *
 * @author Admin
 */
public class TruongHoc {
    private String ten;
    private String diaChi;
    private String maSoThue;
    private int namThanhLap;
    

    public TruongHoc(String ten, String diaChi, String maSoThue, int namThanhLap, int soKhoa) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.maSoThue = maSoThue;
        this.namThanhLap = namThanhLap;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public int getNamThanhLap() {
        return namThanhLap;
    }

    public void setNamThanhLap(int namThanhLap) {
        this.namThanhLap = namThanhLap;
    }

    @Override
    public String toString() {
        return "TruongHoc{" + "ten=" + ten + ", diaChi=" + diaChi + ", maSoThue=" + maSoThue + ", namThanhLap=" + namThanhLap + '}';
    }
    

}
