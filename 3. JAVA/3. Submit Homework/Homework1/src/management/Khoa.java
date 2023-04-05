/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

/**
 *
 * @author Admin
 */
public class Khoa {

    private String maKhoa;
    private String tenKhoa;
    private String truongKhoa;
    private String tenTruong;

    public Khoa(String maKhoa, String tenKhoa, String truongKhoa, String tenTruong) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.truongKhoa = truongKhoa;
        this.tenTruong = tenTruong;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getTruongKhoa() {
        return truongKhoa;
    }

    public void setTruongKhoa(String truongKhoa) {
        this.truongKhoa = truongKhoa;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

    @Override
    public String toString() {
        return "Khoa{" + "maKhoa=" + maKhoa + ", tenKhoa=" + tenKhoa + ", truongKhoa=" + truongKhoa + ", tenTruong=" + tenTruong + '}';
    }

}
