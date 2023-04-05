/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daonguoccacso;

/**
 *
 * @author Admin
 */
public class SoNguyen {

    public static void main(String[] args) {

        int daySo = 1234;
        int daoNguoc = 0;

        int a = daySo % 10;
        daoNguoc = daoNguoc * 10 + a;
        daySo = daySo / 10;

        a = daySo % 10;
        daoNguoc = daoNguoc * 10 + a;
        daySo = daySo / 10;

        a = daySo % 10;
        daoNguoc = daoNguoc * 10 + a;
        daySo = daySo / 10;

        a = daySo % 10;
        daoNguoc = daoNguoc * 10 + a;
        System.out.println("Số 1234 sau khi đảo ngược là: " + daoNguoc);

        int tong = 0;
        daySo = 1234;

        int b = daySo % 10;
        tong += b;
        daySo = daySo / 10;

        b = daySo % 10;
        tong += b;
        daySo = daySo / 10;

        b = daySo % 10;
        tong += b;
        daySo = daySo / 10;

        b = daySo % 10;
        tong += b;
        System.out.println("Tổng các số trong dãy 1234 là: " + tong);

        daySo = 1234;
        int soDau = daySo / 1000;
        int soCuoi = daySo % 10;
        System.out.println("Tổng chữ số đầu và cuối trong dãy 1234 là: " + (soDau + soCuoi));

    }

}
