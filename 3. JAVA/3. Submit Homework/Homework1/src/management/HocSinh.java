/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

/**
 *
 * @author Admin
 */
public class HocSinh {

    private String maSinhVien;
    private String tenSinhVien;
    private int tuoi;
    private String email;
    private String diaChi;
    private double diemTrungBinh;
    private String maLop;

    public HocSinh(String maSinhVien, String tenSinhVien, int tuoi, String email, String diaChi, double diemTrungBinh, String maLop) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.tuoi = tuoi;
        this.email = email;
        this.diaChi = diaChi;
        this.diemTrungBinh = diemTrungBinh;
        this.maLop = maLop;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    @Override
    public String toString() {
        return "HocSinh{" + "maSinhVien=" + maSinhVien + ", tenSinhVien=" + tenSinhVien + ", tuoi=" + tuoi + ", email=" + email + ", diaChi=" + diaChi + ", diemTrungBinh=" + diemTrungBinh + ", maLop=" + maLop + '}';
    }

}
