/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_01;

/**
 *
 * @author Admin
 */
public class RectangleExercise {

    public static void main(String[] args) {
        double width = 5.6;
        double height = 8.5;

        double perimeter = (width + height) * 2;
        double area = width * height;

        System.out.printf("Area is %1.2f * %1.2f = %1.2f\n", width, height, area);
        System.out.printf("Perimeter is 2 * (%1.2f + %1.2f) = %1.2f\n", width, height, perimeter);
    }
}
