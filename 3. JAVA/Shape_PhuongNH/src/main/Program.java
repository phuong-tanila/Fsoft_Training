package main;

import data.*;

public class Program {
	public static void main(String[] args) {
		
		Circle c = new Circle("yellow");
		Rectangle r = new Rectangle("green");
		Square s = new Square("black");
		
		
		c.showColor();
		r.showColor();
		s.showColor();
		
		c.setRadius(5);
		r.setLength(3);
		r.setWidth(2);
		s.setEdge(6);
		
		System.out.println("\n------------------------------------------");
		System.out.printf("\nChu vi");
		System.out.printf("\nHình tròn: %4.2f", c.calculatePerimeter());
		System.out.printf("\nHình chữ nhật: %4.2f", r.calculatePerimeter());
		System.out.printf("\nHình vuông: %4.2f\n", s.calculatePerimeter());
		System.out.println("------------------------------------------");
		System.out.printf("\nDiện tích");
		System.out.printf("\nHình tròn: %4.2f", c.calculateArea());
		System.out.printf("\nHình chữ nhật: %4.2f", r.calculateArea());
		System.out.printf("\nHình vuông: %4.2f", s.calculateArea());
		
		
	}
}
