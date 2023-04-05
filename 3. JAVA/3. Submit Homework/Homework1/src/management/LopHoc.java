/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

/**
 *
 * @author Admin
 */
public class LopHoc {

    private String maLop;
    private String tenLop;
    private int soSinhVien;
    private String tenGiangVien;
    private String maNganh;

    public LopHoc(String maLop, String tenLop, int soSinhVien, String tenGiangVien, String maNganh) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.soSinhVien = soSinhVien;
        this.tenGiangVien = tenGiangVien;
        this.maNganh = maNganh;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getSoSinhVien() {
        return soSinhVien;
    }

    public void setSoSinhVien(int soSinhVien) {
        this.soSinhVien = soSinhVien;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    @Override
    public String toString() {
        return "LopHoc{" + "maLop=" + maLop + ", tenLop=" + tenLop + ", soSinhVien=" + soSinhVien + ", tenGiangVien=" + tenGiangVien + ", maNganh=" + maNganh + '}';
    }

    
}
