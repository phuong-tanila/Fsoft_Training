package data;

public class Rectangle extends Shape{

	private double length;
	private double width;

	public Rectangle(String color) {
		super(color);
	}
	
	public Rectangle(String color, double length, double width) {
		super(color);
		this.length = length;
		this.width = width;
	}
	
	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	@Override
	public double calculatePerimeter() {
		return (length + width) * 2;
	}
	@Override
	public double calculateArea() {
		return length * width;
	}
	
	public void showColor() {
		System.out.printf("\nRectangle is %5s\n", getColor());
	}
}
