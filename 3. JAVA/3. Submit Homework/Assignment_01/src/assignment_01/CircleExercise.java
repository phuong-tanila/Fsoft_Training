/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_01;

/**
 *
 * @author Admin
 */
public class CircleExercise {
    public static final double R = 7.5;
    public static final float PI = 3.14159265359f;
    
    public static void main(String[] args) {
        double area = PI * R * R;
        double perimeter = R * 2 * PI;
        
        System.out.println("Perimeter is = " + perimeter);
        System.out.println("Area is = " + area);
    }
}
