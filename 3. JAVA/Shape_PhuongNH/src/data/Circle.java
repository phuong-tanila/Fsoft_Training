package data;

public class Circle extends Shape {

	private double radius;
	
	private static final double PI = 3.14;
	
	public Circle(String color) {
		super(color);
	}

	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calculatePerimeter() {
		return radius * 2 * PI;
	}

	@Override
	public double calculateArea() {
		return radius * radius * PI;
	}
	
	public void showColor() {
		System.out.printf("\nCircle is %5s\n", getColor());
	}

}
